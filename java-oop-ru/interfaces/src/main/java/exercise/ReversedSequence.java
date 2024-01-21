package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String reversed;

    public ReversedSequence(String charSequence) {
        StringBuilder reversed = new StringBuilder();
        for (int i = 0; i < charSequence.length(); i++) {
           reversed.append(charSequence.charAt(charSequence.length() - 1 - i));
        }
        this.reversed = reversed.toString();
    }

    @Override
    public int length() {
        return this.reversed.length();
    }

    @Override
    public char charAt(int index) {
        return this.reversed.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.reversed.subSequence(start, end);
    }

    @Override
    public String toString() {
        return this.reversed;
    }
}
// END
