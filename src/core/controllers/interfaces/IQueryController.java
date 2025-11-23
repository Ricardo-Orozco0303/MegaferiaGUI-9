package core.controllers.interfaces;

import core.controllers.utils.Response;

public interface IQueryController extends IController {

    Response getBooksByAuthor(String authorId);

    Response getBooksByFormat(String format);

    Response getAuthorsWithMorePublishers();
}
