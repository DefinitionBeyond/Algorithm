package DP;

import java.util.Scanner;

/**
 * 计算相似单词经过增删改最少步骤可以，从一个变到另一个
 * <p>
 * 显然是动态规划中的最短路径的问题
 * <p>
 * 如果两个字符串的第n个字符相等的时候，dp[i][j]的状态可以直接推到的dp[i+1][j+1]
 * <p>
 * 把增删改分别定义为 下转移dp[i][j]=dp[i-1][j]+1，右转移dp[i][j]=dp[i][j-1]+1，对角转移dp[i][j]=dp[i-1][j-1]+1
 * <p>
 * 状态的转移方程到右下角，就是最短路径的选择
 */

public class changworld {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String a = cin.nextLine();
            String b = cin.nextLine();
            System.out.println(new changworld().deal(a, b));
        }
    }

    public int deal(String s, String str) {
        int[][] dp = new int[s.length()][str.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < str.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < str.length(); j++) {
                if (s.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = getMin(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[s.length() - 1][str.length() - 1];
    }

    public int getMin(int a, int b, int c) {
        int t = a > b ? b : a;
        return t > c ? c : t;
    }
}
