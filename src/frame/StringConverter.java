package frame;

import org.apache.commons.lang3.text.WordUtils;

import java.util.HashMap;

public class StringConverter {

    public static String toUpperCase(String s) {
        return s.toUpperCase();
    }

    public static String toLowerCase(String s) {
        return s.toLowerCase();
    }

    public static String capitalizeWords(String s) {
        return WordUtils.capitalize(s);
    }

    public static String KeyboardSwitchENRU(String s) {
        StringBuffer result = new StringBuffer();
        for (char ch : s.toCharArray()) {
            result.append(ENRUMap.get(ch));
        }
        return result.toString();
    }

    public static String KeyboardSwitchRUEN(String s) {
        StringBuffer result = new StringBuffer();
        for (char ch : s.toCharArray()) {
            result.append(RUENMap.get(ch));
        }
        return result.toString();
    }

    public static HashMap<Character, Character> ENRUMap;

    static {
        ENRUMap = new HashMap<>();

        ENRUMap.put(' ', ' ');

        // Nums
        ENRUMap.put('!', '!');
        ENRUMap.put('@', '"');
        ENRUMap.put('#', '№');
        ENRUMap.put('$', ';');
        ENRUMap.put('%', '%');
        ENRUMap.put('^', ':');
        ENRUMap.put('&', '?');
        ENRUMap.put('*', '*');
        ENRUMap.put('(', '(');
        ENRUMap.put(')', ')');
        ENRUMap.put('_', '_');
        ENRUMap.put('+', '+');

        // Upper case
        ENRUMap.put('~', 'Ё');
        ENRUMap.put('Q', 'Й');
        ENRUMap.put('W', 'Ц');
        ENRUMap.put('E', 'У');
        ENRUMap.put('R', 'К');
        ENRUMap.put('T', 'Е');
        ENRUMap.put('Y', 'Н');
        ENRUMap.put('U', 'Г');
        ENRUMap.put('I', 'Ш');
        ENRUMap.put('O', 'Щ');
        ENRUMap.put('P', 'З');
        ENRUMap.put('{', 'Х');
        ENRUMap.put('}', 'Ъ');
        ENRUMap.put('A', 'Ф');
        ENRUMap.put('S', 'Ы');
        ENRUMap.put('D', 'В');
        ENRUMap.put('F', 'А');
        ENRUMap.put('G', 'П');
        ENRUMap.put('H', 'Р');
        ENRUMap.put('J', 'О');
        ENRUMap.put('K', 'Л');
        ENRUMap.put('L', 'Д');
        ENRUMap.put(':', 'Ж');
        ENRUMap.put('"', 'Э');
        ENRUMap.put('|', '/');
        ENRUMap.put('Z', 'Я');
        ENRUMap.put('X', 'Ч');
        ENRUMap.put('C', 'С');
        ENRUMap.put('V', 'М');
        ENRUMap.put('B', 'И');
        ENRUMap.put('N', 'Т');
        ENRUMap.put('M', 'Ь');
        ENRUMap.put('<', 'Б');
        ENRUMap.put('>', 'Ю');
        ENRUMap.put('?', ',');

        // Lower case
        ENRUMap.put('`', 'ё');
        ENRUMap.put('q', 'й');
        ENRUMap.put('w', 'ц');
        ENRUMap.put('e', 'у');
        ENRUMap.put('r', 'к');
        ENRUMap.put('t', 'е');
        ENRUMap.put('y', 'н');
        ENRUMap.put('u', 'г');
        ENRUMap.put('i', 'ш');
        ENRUMap.put('o', 'щ');
        ENRUMap.put('p', 'з');
        ENRUMap.put('[', 'х');
        ENRUMap.put(']', 'ъ');
        ENRUMap.put('a', 'ф');
        ENRUMap.put('s', 'ы');
        ENRUMap.put('d', 'в');
        ENRUMap.put('f', 'а');
        ENRUMap.put('g', 'п');
        ENRUMap.put('h', 'р');
        ENRUMap.put('j', 'о');
        ENRUMap.put('k', 'л');
        ENRUMap.put('l', 'д');
        ENRUMap.put(';', 'ж');
        ENRUMap.put('\'', 'э');
        ENRUMap.put('\\', '\\');
        ENRUMap.put('z', 'я');
        ENRUMap.put('x', 'ч');
        ENRUMap.put('c', 'с');
        ENRUMap.put('v', 'м');
        ENRUMap.put('b', 'и');
        ENRUMap.put('n', 'т');
        ENRUMap.put('m', 'ь');
        ENRUMap.put(',', 'б');
        ENRUMap.put('.', 'ю');
        ENRUMap.put('/', '.');
    }

    public static HashMap<Character, Character> RUENMap;

    static {
        RUENMap = new HashMap<>();

        RUENMap.put(' ', ' ');

        // Nums
        RUENMap.put('!', '!');
        RUENMap.put('"', '@');
        RUENMap.put('№', '#');
        RUENMap.put(';', '$');
        RUENMap.put('%', '%');
        RUENMap.put(':', '^');
        RUENMap.put('?', '&');
        RUENMap.put('*', '*');
        RUENMap.put('(', '(');
        RUENMap.put(')', ')');
        RUENMap.put('_', '_');
        RUENMap.put('+', '+');

        // Upper case
        RUENMap.put('Ё', '~');
        RUENMap.put('Й', 'Q');
        RUENMap.put('Ц', 'W');
        RUENMap.put('У', 'E');
        RUENMap.put('К', 'R');
        RUENMap.put('Е', 'T');
        RUENMap.put('Н', 'Y');
        RUENMap.put('Г', 'U');
        RUENMap.put('Ш', 'I');
        RUENMap.put('Щ', 'O');
        RUENMap.put('З', 'P');
        RUENMap.put('Х', '{');
        RUENMap.put('Ъ', '}');
        RUENMap.put('Ф', 'A');
        RUENMap.put('Ы', 'S');
        RUENMap.put('В', 'D');
        RUENMap.put('А', 'F');
        RUENMap.put('П', 'G');
        RUENMap.put('Р', 'H');
        RUENMap.put('О', 'J');
        RUENMap.put('Л', 'K');
        RUENMap.put('Д', 'L');
        RUENMap.put('Ж', ':');
        RUENMap.put('Э', '"');
        RUENMap.put('/', '|');
        RUENMap.put('Я', 'Z');
        RUENMap.put('Ч', 'X');
        RUENMap.put('С', 'C');
        RUENMap.put('М', 'V');
        RUENMap.put('И', 'B');
        RUENMap.put('Т', 'N');
        RUENMap.put('Ь', 'M');
        RUENMap.put('Б', '<');
        RUENMap.put('Ю', '>');
        RUENMap.put(',', '?');

        // Lower case
        RUENMap.put('ё', '`');
        RUENMap.put('й', 'q');
        RUENMap.put('ц', 'w');
        RUENMap.put('у', 'e');
        RUENMap.put('к', 'r');
        RUENMap.put('е', 't');
        RUENMap.put('н', 'y');
        RUENMap.put('г', 'u');
        RUENMap.put('ш', 'i');
        RUENMap.put('щ', 'o');
        RUENMap.put('з', 'p');
        RUENMap.put('х', '[');
        RUENMap.put('ъ', ']');
        RUENMap.put('ф', 'a');
        RUENMap.put('ы', 's');
        RUENMap.put('в', 'd');
        RUENMap.put('а', 'f');
        RUENMap.put('п', 'g');
        RUENMap.put('р', 'h');
        RUENMap.put('о', 'j');
        RUENMap.put('л', 'k');
        RUENMap.put('д', 'l');
        RUENMap.put('ж', ';');
        RUENMap.put('э', '\'');
        RUENMap.put('\\', '\\');
        RUENMap.put('я', 'z');
        RUENMap.put('ч', 'x');
        RUENMap.put('с', 'c');
        RUENMap.put('м', 'v');
        RUENMap.put('и', 'b');
        RUENMap.put('т', 'n');
        RUENMap.put('ь', 'm');
        RUENMap.put('б', ',');
        RUENMap.put('ю', '.');
        RUENMap.put('.', '/');
    }
}
