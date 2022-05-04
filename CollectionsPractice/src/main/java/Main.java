
import optional.FileHelper;
import optional.StringHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = "D:/test.txt";
        String typeOperation = "duplicates";
        String content = FileHelper.readFile(path, StandardCharsets.UTF_8);

        if (typeOperation.equals("freguency")) {
            frequency(getArrayWords(content), 2);
        } else if (typeOperation.equals("length")) {
            length(getArrayWords(content), 2);
        } else if (typeOperation.equals("duplicates")) {
            duplicates(getArrayWords(content), 2);
        }
        Arrays.stream(getArrayWords(content)).forEach(x -> System.out.println(x.hashCode()));

    }

    public static String[] getArrayWords(String txt) {
        String[] sbr;
        return sbr = txt.split("\\W+");

    }

    public static void frequency(String[] words, int limit) {
        putToMap(words).entrySet().stream()
                .sorted((x, y) -> y.getValue().compareTo(x.getValue()))
                .limit(limit)
                .sorted((x, y) -> y.getKey().compareTo(x.getKey()))
                .forEach(x -> System.out.println(x));
    }

    public static void length(String[] array, int limit) {
        Arrays.stream(array)
                .sorted((x, y) -> y.length() - x.length())
                .limit(limit)
                .forEach(x -> System.out.println(x + " " + x.length()));
    }

    public static void duplicates(String[] words, int limit) {
        int count = 0;
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            if (map.get(words[i]) == 2) {
                count++;
                list.add(words[i]);
            }
            if (count == 3) {
                break;
            }
        }

        list.stream().map(x -> StringHelper.reverseString(x))
                .forEach(x -> System.out.println(x.toUpperCase()));
    }

    public static Map<String, Integer> putToMap(String[] array) {
        Map<String, Integer> finalMap2 = new LinkedHashMap<>();

        for (String sb : array) {
            finalMap2.put(sb, finalMap2.getOrDefault(sb, 0) + 1);
        }

        return finalMap2;
    }

}


