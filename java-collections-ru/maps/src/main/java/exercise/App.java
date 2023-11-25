package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String text) {
        if (text.length() == 0) {
            return Map.of();
        }
        var words = text.split(" ");
        var wordCount = new HashMap<String, Integer>();
        for (var word : words) {
            wordCount.compute(word, (key, value) -> value == null ? 1 : value + 1);
        }
        return wordCount;
    }

    public static String toString(Map<String, Integer> wordCount) {
        if (wordCount.isEmpty()) {
            return "{}";
        }
        var words = wordCount.keySet();
        var sb = new StringBuilder("\n");
        for (var word : words) {
            sb.append("  ").append(word).append(": ").append(wordCount.get(word)).append("\n");
        }
        return "{" + sb + "}";
    }
}
//END
