package exercise;

import java.util.ArrayList;

// BEGIN
public class App {
    public static boolean scrabble(String letters, String word) {
        var lettersChars = new ArrayList<>();
        var wordChars = new ArrayList<>();
        for (var lettersChar : letters.toLowerCase().toCharArray()) {
            lettersChars.add(lettersChar);
        }
        for (var wordChar : word.toLowerCase().toCharArray()) {
            wordChars.add(wordChar);
        }
        var counter = 0;
        for (var wordChar : wordChars) {
            if (lettersChars.contains(wordChar)) {
                counter += 1;
                lettersChars.remove(wordChar);
            }
        }
        return counter == word.length();
    }
}
//END
