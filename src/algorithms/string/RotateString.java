package algorithms.string;

import java.util.Arrays;

public class RotateString {

    private static void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] arg) {
        String str = "abcdef";
        char[] A = str.toCharArray();
        int offset=3;
        int len = A.length;
        offset %= len;
        reverse(A, 0, len - offset - 1);   //abc -> cba
        reverse(A, len - offset, len - 1); //dev -> fed
        reverse(A, 0, len - 1); //cbafed -> defabc
        System.out.println("\n"+Arrays.toString(A));
    }
}
