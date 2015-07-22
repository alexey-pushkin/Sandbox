package frame;

import org.apache.commons.lang3.text.WordUtils;

public class StringConverter {

    public static String toUpperCase(String s) {
        return s.toUpperCase();
    }

    public static String toLowerCase(String s) {
        return s.toLowerCase();
    }

    public static String capitalizeSentences(String s) {
        return WordUtils.capitalize(s, '.');
    }

    public static String capitalizeWords(String s) {
        return WordUtils.capitalize(s);
    }
}
