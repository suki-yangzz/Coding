package algorithms.string;

import java.util.*;

/*
如果一个单词通过循环右移获得的单词，我们称这些单词都为一种循环单词。
例如：picture 和 turepic 就是属于同一种循环单词。 现在给出n个单词，需要统计这个n个单词中有多少种循环单词。
 */

public class GetRotationWords {

    public static void main(String[] args) {
        //思路：把要测试的单词后再重复下这个单词，如：picture ，变成 picturepicture
        String[] strArr = {"picture", "turepic", "icturep", "word", "ordw", "milk"};
        ArrayList<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < strArr.length; i ++) {
            String s = strArr[i];
            if (!list.contains(s)) {
                count++;
                for (int j = 0; j < s.length() - 1; j ++) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(s);
                    sb.append(s);
                    String tmp = sb.substring(j, s.length() + j);
                    list.add(tmp);
                }
            }
        }
        System.out.println(count);
    }
}

