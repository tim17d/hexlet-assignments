package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        var defaultList1 = new ArrayList<>(List.of(5, 7, 25, 0, 31));
        var expectedList1 = new ArrayList<>(List.of(5, 7));
        assertThat(App.take(defaultList1, 2)).isEqualTo(expectedList1);

        var defaultList2 = new ArrayList<>(List.of(5, 7, 25));
        assertThat(App.take(defaultList2, 3)).isEqualTo(defaultList2);

        var defaultList3 = new ArrayList<>(List.of(5));
        assertThat(App.take(defaultList3, 4)).isEqualTo(defaultList3);
        // END
    }
}
