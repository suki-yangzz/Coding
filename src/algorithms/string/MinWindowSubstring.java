package algorithms.string;

public class MinWindowSubstring {

    /**
     * @param source:
     *            A string
     * @param target:
     *            A string
     * @return: A string denote the minimum window Return "" if there is no such
     *          a string
     */
    public static String minWindow(String source, String target) {
        int ans = Integer.MAX_VALUE;
        String minStr = "";
        int[] sourcehash = new int[256];
        int[] targethash = new int[256];
        initTargetHash(targethash, target);
        int j = 0, i = 0;
        for (i = 0; i < source.length(); i++) {
            while (!valid(sourcehash, targethash) && j < source.length()) {
                sourcehash[source.charAt(j)]++;
                j++;
            }
            if (valid(sourcehash, targethash) && ans > j - i) {
                ans = j - i;
                minStr = source.substring(i, j);
            }
            sourcehash[source.charAt(i)]--;
        }
        return minStr;
    }

    private static void initTargetHash(int[] targethash, String target) {
        for (char ch : target.toCharArray()) {
            targethash[ch]++;
        }
    }

    private static boolean valid(int[] sourcehash, int[] targethash) {
        for (int i = 0; i < 256; i++) {
            if (targethash[i] > sourcehash[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {
        System.out.println(minWindow("abdefbeaccfcgbc", "abc"));
    }
}
