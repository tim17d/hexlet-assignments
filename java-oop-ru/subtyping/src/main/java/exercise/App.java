package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        storage.toMap().forEach((key, value) -> {
            storage.unset(key);
            storage.set(value, key);
        });
    }
}
// END
