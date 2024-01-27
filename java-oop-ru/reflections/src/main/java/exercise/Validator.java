package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Object obj) {
        try {
            var nullFields = new ArrayList<String>();
            var fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class)) {
                    if (field.get(obj) == null) {
                        nullFields.add(field.getName());
                    }
                }
            }
            return nullFields;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, List<String>> advancedValidate(Object obj) {
        var notValidFields = new HashMap<String, List<String>>();
        var fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class) || field.isAnnotationPresent(MinLength.class)) {
                notValidFields.put(field.getName(), new ArrayList<>());
                if (field.isAnnotationPresent(NotNull.class)) {
                    try {
                        if (field.get(obj) == null) {
                            notValidFields.get(field.getName()).add("can not be null");
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    if (field.isAnnotationPresent(MinLength.class) && field.get(obj) != null
                            && field.get(obj) instanceof String) {
                        var minLengthValue = field.getAnnotation(MinLength.class).minLength();
                        if (((String) field.get(obj)).length() < minLengthValue) {
                            notValidFields.get(field.getName()).add("length less than " + minLengthValue);
                        }
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                if (notValidFields.get(field.getName()).isEmpty()) {
                    notValidFields.remove(field.getName());
                }
            }
        }
        return notValidFields;
    }
}
// END
