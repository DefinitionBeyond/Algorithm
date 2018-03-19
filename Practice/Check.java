package Practice;

/**
 * @author liutao
 * @date 2018/3/19  14:00
 */

import java.util.Scanner;

/**
 * 检查输入是否是2的m次方
 * return true or false
 */
public class Check {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            String s = Integer.toBinaryString(n);
            // String s1 = Integer.toBinaryString(n-1);
            if (s.length() % 2 == 1)
                // System.out.println(s&s1);
                System.out.println((n & (n - 1)) == 0 ? true : false);
            else {
                System.out.println(false);
            }
        }
    }

    public static boolean acc(int n) {
        if (n == 1) {
            return true;
        } else {
            while (n >= 2) {
                n >>= 1;
            }
            if (n == 1) return true;
        }
        return false;
    }
}
//    100
//    011
//  10100
//  10011
//  10000
//  01111
//1000000

