package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Palindrome Partitioning
 * Return all possible palindrome partitioning of s.
 * 1.长度标准：无（固定）
 * 2.可选的范围：从start开始到最后一个
 * 3.往前走一步：temp加入这个数，然后start加1表示从下一位加起
 * 4.后退一步：temp减去这个数
 * 5.特别的case：start到最后一位
 * 6.关于重复：无
 */

public class PalindromePartition {

    public static List<List<String>> partition(String s) {
        List<String> item = new ArrayList<String>();
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0)
            return res;
        dfs(s, 0, item, res);
        return res;
    }

    public static void dfs(String s, int start, List<String> item,List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(item));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);// 每一轮dfs进来都是先取第一个数，start index，可以不用stringbuffer来存
            if (isPalindrome(str)) {
                item.add(str);
                dfs(s, i + 1, item, res);// 上面取到i，所以下一个start index就是i+1
                item.remove(item.size() - 1);
            }
        }
    }
    public static boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }

    public static void main (String[] args) {
        System.out.println(partition("aabbbb"));
    }
}
