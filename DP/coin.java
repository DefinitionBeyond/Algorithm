package DP;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author liutao
 * @date 2018/3/19  14:29
 */

/**
 * 状态转移方程d(i)=min{ d(i-vj)+1 }
 */
public class coin {


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = cin.nextInt();//输入硬币面值种类
        int[] Vi = new int[n];
        for (int i = 0; i < n; i++) {
            Vi[i] = cin.nextInt();
        }
        while (cin.hasNext()) {
            int money = cin.nextInt();
            System.out.println(solution(money, Vi, map));
            System.out.println(solution(money, Vi));
        }
    }

    public static int solution(int money, int Vi[], HashMap<Integer, Integer> map) {

        if (money == 0) return 0;
        if (money == 1) return solution(money - 1, Vi, map) + 1;
        if (map.containsKey(money)) {//如果map中包括这个money这个键，直接取
            return map.get(money);
        } else {
            boolean flag = true;
            int t = 0;
            for (int i = Vi.length - 1; i >= 0; i--) {
                if (money >= Vi[i] && solution(money - 1, Vi, map) > solution(money - Vi[i], Vi, map)) {
                    flag = false;//标记面值为Vi[i]的比使用面值为1的更优
                    t = i;
                }
            }
            if (flag == false) {
                map.put(money, solution(money - Vi[t], Vi, map) + 1);
                return solution(money - Vi[t], Vi, map) + 1;
            } else {
                //如果用面值为1更优
                map.put(money, solution(money - 1, Vi, map) + 1);
                return solution(money - 1, Vi, map) + 1;
            }
        }
    }

    public static int solution(int money, int[] Vi) {
        int[] dp = new int[money];
        dp[0] = 0;
        for (int i = 1; i < money; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= money; i++) {
            for (int j = 0; j < Vi.length; j++) {
                if (i >= Vi[j] && dp[i - Vi[j]] + 1 < dp[i]) {
                    dp[i] = dp[i - Vi[j]] + 1;
                }
            }
        }
        return dp[money];
    }
}
