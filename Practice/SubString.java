package Practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liutao
 * @date 2018/3/19  14:11
 */

/**
 * 寻找最大升序子串的长度
 */
public class SubString {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = cin.nextInt();
            }
            System.out.println(opreat(a));
        }
    }

    public static int opreat(int a[]) {
        int len = a.length;
        int[] b = new int[len];
        b[0] = 1;
        int i = 0, j = 0;
        for (i = 0; i < len; i++) {
            for (j = i; j >= 0; j--) {
                if (a[j] < a[i]) {
                    b[i] = getMax(1, b[j] + 1);
                    break;
                }
            }
        }
        return Sort(b);
    }

    public static int Sort(int a[]) {
        Arrays.sort(a);
        return a[a.length - 1];
    }

    public static int getMax(int a, int b) {
        if (a > b) return a;
        else return b;
    }


}
