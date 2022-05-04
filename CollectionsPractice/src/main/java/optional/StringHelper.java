package optional;

public class StringHelper {
    public static String reverseString(String str) {

        char[] array = str.toCharArray();
        String result = "";

        for (int i = array.length - 1; i >= 0; i--) {
            result = result + array[i];
        }

        return result;

    }
}
