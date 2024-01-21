package exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReversedSequenceTest {
    private static final ReversedSequence REVERSED_SEQUENCE = new ReversedSequence("abcdef");

    @Test
    public void testLength() {
        assertThat(REVERSED_SEQUENCE.length()).isEqualTo(6);
    }

    @Test
    public void testCharAt() {
        assertThat(REVERSED_SEQUENCE.charAt(1)).isEqualTo('e');
    }

    @Test
    public void testSubsequence() {
        assertThat(REVERSED_SEQUENCE.subSequence(2, 5)).isEqualTo("dcb");
    }

    @Test
    public void testToString() {
        assertThat(REVERSED_SEQUENCE.toString()).isEqualTo("fedcba");
    }
}
