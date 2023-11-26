package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static int getCountOfFreeEmails(List<String> emails) {
        return (int) emails.stream()
                .filter(email -> email.contains("@yandex.ru") || email.contains("@gmail.com") || email.contains("@hotmail.com"))
                .count();
    }
}
// END
