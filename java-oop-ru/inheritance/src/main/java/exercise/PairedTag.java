package exercise;

import java.util.Map;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String text;
    private List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String text, List<Tag> children) {
        this.name = name;
        this.attributes = attributes;
        this.text = text;
        this.children = children;
    }

    public String toString() {
        var sj = new StringJoiner(" ");
        sj.add(this.name);
        attributes.forEach((key, value) -> sj.add(key + "=\"" + value + "\""));
        return "<" + sj + ">" + this.text
                + children.stream().map(Object::toString).collect(Collectors.joining()) + "</" + this.name + ">";
    }
}
// END
