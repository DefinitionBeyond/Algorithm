package one_privi.leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {//最长公共前缀

    public static void main(String[] args) {
        String []s = {"asdef","asdgewasd","asdtha","asdhtwsdf"};
//        String[] s=  {"a","b"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(s));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return null;
        }

        if (strs.length == 0) {
            return "";
        }
        int min = Integer.MAX_VALUE;//记录最短字符串的长度
       for(String str : strs){
            if(str==null){
                return null;
            }
            if(min>str.length()){
                min = str.length();
            }
       }
       boolean flag;
        int i ;
        for (i = 0 ; i < min ;i++){
            flag = true;
            for (int j = 1 ; j < strs.length ;j++){
                if (strs[0].charAt(i)!=strs[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if(!flag){
               break;
            }
        }
        return strs[0].substring(0,i);
    }
}
