package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String text;
    private TagInterface innerTag;

    public LabelTag(String text, TagInterface innerTag) {
        this.text = text;
        this.innerTag = innerTag;
    }

    @Override
    public String render() {
        return "<label>" + this.text + this.innerTag.render() + "</label>";
    }
}
// END
