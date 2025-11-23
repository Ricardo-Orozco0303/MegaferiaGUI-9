package core.controllers.utils;

import java.util.regex.Pattern;

/**
 * Utilidades para validar datos de entrada
 */
public final class ValidationUtils {

    private static final int MAX_ID_DIGITS = 15;
    private static final long MIN_ID_VALUE = 0L;
    
    private static final Pattern NIT_REGEX = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d");
    private static final Pattern ISBN_REGEX = Pattern.compile("\\d{3}-\\d-\\d{2}-\\d{6}-\\d");
    private static final String PLACEHOLDER_PREFIX = "Seleccione";

    private ValidationUtils() {
    }

    public static boolean isPlaceholder(String value) {
        return value != null && value.startsWith(PLACEHOLDER_PREFIX);
    }

    public static boolean isValidId(long id) {
        if (id < MIN_ID_VALUE) {
            return false;
        }
        String idAsString = String.valueOf(id);
        return idAsString.length() <= MAX_ID_DIGITS;
    }

    public static boolean isValidNit(String nit) {
        if (nit == null) {
            return false;
        }
        return NIT_REGEX.matcher(nit).matches();
    }

    public static boolean isValidIsbn(String isbn) {
        if (isbn == null) {
            return false;
        }
        return ISBN_REGEX.matcher(isbn).matches();
    }

    public static boolean isPositive(double value) {
        return value > 0;
    }

    public static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
