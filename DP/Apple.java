package DP;

import java.util.*;
/**
 * @author liutao
 * Created by hasee-PC on 2017/6/10.
 */

/**
 * 有一个m*n的棋盘，每个格子放着若干个apple
 * 小明在棋盘左上角，他只能向右走或者向下走，到达右下角的时候，最多能够得到多少apple
 */
public class Apple {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int row = cin.nextInt();
            int lrc = cin.nextInt();
            int a[][] = new int[row][lrc];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < lrc; j++) {
                    a[i][j] = cin.nextInt();
                }
            }
            System.out.println(getPath(a));
        }
    }

    public static int getPath(int a[][]) {
        int r = a.length;
        int l = a[0].length;
        int[][] s = new int[r][l];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < l; j++) {
                if (i == 0 && j == 0) s[i][j] = a[i][j];
                else if (i == 0) s[i][j] = a[i][j] + s[i][j - 1];
                else if (j == 0) s[i][j] = a[i][j] + s[i - 1][j];
                else {
                    s[i][j] = getMax((a[i][j] + s[i - 1][j]), (a[i][j] + s[i][j - 1]));
                }
            }
        }
        return s[r - 1][l - 1];
    }

    public static int getMax(int a, int b) {
        if (a > b) return a;
        else return b;
    }
//    public static void Scanf(int i , int j){
//        int [][]a  = new int [i][j];
//        for(int r = 0;r<i;r++){
//            for(int l = 0 ;l<j;l++){
//                a[i][j] =
//            }
//        }
//    }
}
