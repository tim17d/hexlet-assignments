package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int limit) {
        return homes.stream()
                .sorted(Home::compareTo)
                .limit(limit)
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}
// END
