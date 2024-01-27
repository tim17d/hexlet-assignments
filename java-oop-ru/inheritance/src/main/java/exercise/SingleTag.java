package exercise;

import java.util.Map;
import java.util.StringJoiner;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String toString() {
        var sj = new StringJoiner(" ", "<", ">");
        sj.add(this.name);
        attributes.forEach((key, value) -> sj.add(key + "=\"" + value + "\""));
        return sj.toString();
    }
}
// END
