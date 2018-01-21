package algorithms.backtracking;

/*
 * Given a string s, return all the palindromic permutations (without duplicates) of it.
 * Return an empty list if no palindromic permutation could be form.
 * Given s = "aabb", return ["abba", "baab"].
 * Given s = "abc", return [].
 * 这道题目就相对来说简单多了，就跟permutation II类似，如果不写那个比较重要的判断句，那么久会出现很多的重复的。整题原理就是找到所有的组合可能性，再选择其中合适的
 * 1.长度标准：无（固定）
 * 2.可选的范围：对于一个array的所有permutation，这个array有重复（所以多了一句判断句），而且前后可以颠倒（所以用visited）。具体参考permutation II
 * 3.往前走一步：sb加入这个数，visited改为true
 * 4.后退一步：sb减去，visited改为false
 * 5.特别的case：到了长度检查。
 * 6.关于重复：因为可以有重复aabb可能会有abba和abba，第一个a在第一个，第二个a在第二个
 */

import java.util.ArrayList;
import java.util.List;

public class GeneratePalindrome {

    public static List<String> generatePalindromes(String s) {
        List<String> res=new ArrayList<String>();
        boolean[] visited=new boolean[s.length()];
        char[] model=s.toCharArray();
        StringBuffer sb=new StringBuffer();
        dfs(res,model,visited,sb);
        return res;
    }

    public static void dfs(List<String> res,char[] model,boolean[] visited,StringBuffer sb){
        if(sb.toString().length()==model.length){
            if(isPalindrome(sb.toString())){
                res.add(sb.toString());
            }
            return;
        }
        for(int i=0;i<model.length;i++){
            if (i > 0 && !visited[i - 1] && model[i] == model[i - 1]) // 这个非常的重要！！！！！！！！！！
                continue;
            if(!visited[i]){
                sb.append(model[i]);
                visited[i]=true;
                dfs(res,model,visited,sb);
                visited[i]=false;
                sb.deleteCharAt(sb.length()-1);
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
        System.out.println(generatePalindromes("aabbbb"));
    }
}
