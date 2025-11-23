package core.controllers.strategies;

import core.controllers.dto.BookCreationRequest;
import core.controllers.utils.MessageUtils;
import core.models.Author;
import core.models.Book;
import core.models.Narrator;
import core.models.Publisher;
import core.models.factory.BookFactory;
import core.repositories.interfaces.IRepository;
import java.util.List;

public class AudiobookStrategy implements BookCreationStrategy {

    private final IRepository<Narrator, Long> narratorRepo;

    public AudiobookStrategy(IRepository<Narrator, Long> narratorRepository) {
        this.narratorRepo = narratorRepository;
    }

    @Override
    public Book create(BookCreationRequest request, List<Author> authors, Publisher publisher, 
                       double price, BookFactory factory) {
        int playbackDuration = extractDuration(request.getDuration());
        long narratorId = extractNarratorId(request.getNarratorId());
        
        validateDuration(playbackDuration);
        Narrator voicePerformer = retrieveAndValidateNarrator(narratorId);

        return factory.createAudiobook(
                request.getTitle(),
                authors,
                request.getIsbn(),
                request.getGenre(),
                request.getFormat(),
                price,
                publisher,
                playbackDuration,
                voicePerformer
        );
    }

    private int extractDuration(String durationText) {
        try {
            return Integer.parseInt(durationText.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageUtils.DURATION_NARRATOR_VALID);
        }
    }

    private long extractNarratorId(String narratorIdText) {
        if (narratorIdText == null) {
            throw new IllegalArgumentException(MessageUtils.NARRATOR_REQUIRED);
        }
        try {
            return Long.parseLong(narratorIdText.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageUtils.DURATION_NARRATOR_VALID);
        }
    }

    private void validateDuration(int duration) {
        if (duration <= 0) {
            throw new IllegalArgumentException(MessageUtils.DURATION_POSITIVE);
        }
    }

    private Narrator retrieveAndValidateNarrator(long narratorId) {
        Narrator narrator = narratorRepo.findById(narratorId).orElse(null);
        if (narrator == null) {
            throw new IllegalArgumentException(MessageUtils.NARRATOR_NOT_FOUND);
        }
        return narrator;
    }
}

