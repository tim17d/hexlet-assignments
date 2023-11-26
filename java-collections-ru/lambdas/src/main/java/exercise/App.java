package exercise;

import java.util.Arrays;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] arrayImage) {
        String[][] horizontallyDoubled = Arrays.stream(arrayImage)
                .map(App::doubleValues)
                .toArray(String[][]::new);
        return Arrays.stream(horizontallyDoubled)
                .flatMap(item -> Arrays.stream(new String[][] {item, item}))
                .toArray(String[][]::new);
    }

    private static String[] doubleValues(String[] items) {
        return Arrays.stream(items)
                .flatMap(item -> Arrays.stream(new String[] {item, item}))
                .toArray(String[]::new);
    }
}
// END
