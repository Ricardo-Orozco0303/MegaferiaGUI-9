package core.controllers.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Fábrica para construir respuestas de los controladores.
 */
public final class ResponseFactory {

    private ResponseFactory() {
        throw new AssertionError("Factory class should not be instantiated");
    }

    public static Response<Map<String, Object>> rows(String message, List<?> rows) {
        Map<String, Object> dataPayload = createDataMap(ResponseKeys.ROWS, rows);
        return Response.success(message, dataPayload);
    }

    public static Response<Map<String, Object>> options(String message, List<?> options) {
        Map<String, Object> dataPayload = createDataMap(ResponseKeys.OPTIONS, options);
        return Response.success(message, dataPayload);
    }

    private static Map<String, Object> createDataMap(String key, List<?> items) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put(key, items);
        return dataMap;
    }
}

