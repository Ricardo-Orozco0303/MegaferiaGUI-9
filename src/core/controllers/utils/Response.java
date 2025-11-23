package core.controllers.utils;

/**
 * Esta clase sirve para devolver respuestas de los controladores
 */
public class Response<T> {

    private static final int SUCCESS_RANGE_START = 200;
    private static final int SUCCESS_RANGE_END = 300;

    private final int statusCode;
    private final String message;
    private final T data;

    private Response(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    /**
     * Crea una respuesta de éxito sin datos extra
     */
    public static <T> Response<T> success(String message) {
        return new Response<>(Status.OK, message, null);
    }

    /**
     * Crea una respuesta positiva con datos incluidos
     */
    public static <T> Response<T> success(String message, T data) {
        return new Response<>(Status.OK, message, data);
    }

    /**
     * Crea una respuesta de error cuando algo falla
     */
    public static <T> Response<T> error(String message) {
        return new Response<>(Status.BAD_REQUEST, message, null);
    }

    /**
     * Crea respuesta de error con datos adicionales
     */
    public static <T> Response<T> error(String message, T data) {
        return new Response<>(Status.BAD_REQUEST, message, data);
    }

    /**
     * Método para saber rápido si todo salió bien
     */
    public boolean isSuccess() {
        return statusCode >= SUCCESS_RANGE_START && statusCode < SUCCESS_RANGE_END;
    }

    /**
     * Saca el mensaje de la respuesta
     */
    public String getMessage() {
        return message;
    }

    /**
     * Saca los datos contenidos en la respuesta
     */
    public T getData() {
        return data;
    }

    /**
     * Devuelve el código de estado
     */
    public int getStatusCode() {
        return statusCode;
    }
}
