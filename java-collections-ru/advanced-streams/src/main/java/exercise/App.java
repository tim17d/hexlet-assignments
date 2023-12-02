package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
public class App {
    public static String getForwardedVariables(String conf) {
        var sb = new StringBuilder();
        Arrays.stream(conf.split("\n"))
                .filter(str -> str.startsWith("environment"))
                .map(str -> str.split("\"")[1])
                .flatMap(str -> Arrays.stream(str.split(",")))
                .filter(str -> str.startsWith("X_FORWARDED_"))
                .map(str -> str.substring(12))
                .forEach(str -> sb.append(str).append(","));
        var result = sb.toString();
        return result.substring(0, result.length() - 1);
    }
}
//END
