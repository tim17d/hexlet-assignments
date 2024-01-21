package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String filePath;

    public FileKV(String filePath, Map<String, String> initialStorage) {
        this.filePath = filePath;
        Utils.writeFile(this.filePath, Utils.serialize(initialStorage));
    }

    @Override
    public void set(String key, String value) {
        var storage = Utils.unserialize(Utils.readFile(this.filePath));
        storage.put(key, value);
        Utils.writeFile(this.filePath, Utils.serialize(storage));
    }

    @Override
    public void unset(String key) {
        var storage = Utils.unserialize(Utils.readFile(this.filePath));
        storage.remove(key);
        Utils.writeFile(this.filePath, Utils.serialize(storage));
    }

    @Override
    public String get(String key, String defaultValue) {
        var storage = Utils.unserialize(Utils.readFile(this.filePath));
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.unserialize(Utils.readFile(this.filePath));
    }
}
// END
