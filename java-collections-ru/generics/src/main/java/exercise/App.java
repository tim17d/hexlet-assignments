package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> bookDetails) {
        var foundBooks = new ArrayList<Map<String, String>>();
        for (var book : books) {
            if (book.entrySet().containsAll(bookDetails.entrySet())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }
}
//END
