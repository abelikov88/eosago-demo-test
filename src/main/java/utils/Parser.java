package utils;

import models.Agreement;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author abelikov
 */
public class Parser {

    private final static Map<Class, TypeReference> types;

    static {
        types = new HashMap<>();
        types.put(Agreement.class, new TypeReference<Map<String, Agreement>>() {});
    }

    public static <T> Map<String, T> parseFromJson(String file, Class<T> clazz) {
        file = (isWindows() ? "src\\main\\resources\\" : "src/main/resources/") + file;
        Map<String, T> parseResult = null;
        ObjectMapper objectMapper = new ObjectMapper().setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            TypeReference type = types.get(clazz);
            if (type == null) {
                throw new IllegalStateException("not type for " + clazz);
            }
            parseResult = objectMapper.readValue(new File(file), type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parseResult;
    }

    private static boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("win"));
    }
}
