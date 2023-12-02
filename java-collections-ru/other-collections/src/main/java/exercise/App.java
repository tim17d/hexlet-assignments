package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        var resultMap = new LinkedHashMap<String, String>();
        var keySet1 = map1.keySet();
        var keySet2 = map2.keySet();

        var setAdded = new TreeSet<>(keySet2);
        setAdded.removeAll(keySet1);
        setAdded.forEach(key -> resultMap.put(key, "added"));

        var setDeleted = new TreeSet<>(keySet1);
        setDeleted.removeAll(keySet2);
        setDeleted.forEach(key -> resultMap.put(key, "deleted"));

        var setIntersected = new TreeSet<>(keySet1);
        setIntersected.retainAll(keySet2);
        setIntersected.forEach(key -> {
            if (map1.get(key).equals(map2.get(key))) {
                resultMap.put(key, "unchanged");
            } else {
                resultMap.put(key, "changed");
            }
        });
        return resultMap;
    }
}
//END
