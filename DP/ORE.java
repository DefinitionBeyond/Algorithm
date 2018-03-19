package DP;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author liutao
 * @date 2018/3/19  14:15
 */
public class ORE {


    /**
     * 01背包问题
     * 问题描述：有num个工人，有n个矿，但是每个矿要求people个人去开采，人不够people，就不能得到矿里面的金子
     * 开采A矿的人，开采完矿，他就再也不开采别的矿了，求num个人能开采的最大金子数目
     * 假设5个矿，那我知道前四个矿的最大产量，我就可以知道五个的最大产量，就是知道i个矿的最大产量，就必须知道i-1个矿的最大
     * 产量，最终当考虑第1座金矿的最大产量时，只要看是否有足够人手开采第1座金矿，有的话，答案是已探明的储量，没有的话就是0，
     * 然后答案汇报到上级，上级再得出第2座金矿开采与不开采得出的较大产量，再往上汇报…,这就是边界，而每个人从上级得到的前提
     * 都是不同的，上级决定开不开采，再将这个前提之一告诉下属，而下属不需要考虑上级给另一个下属什么前提，这是子问题独立。
     */
    public static void main(String arg[]) {
        Scanner cin = new Scanner(System.in);
        HashMap map = new HashMap<Integer, Ore>();
        while (cin.hasNext()) {
            int n = cin.nextInt();//输入总共的矿的数目
            int people, money;
            for (int i = 0; i < n; i++) {
                people = cin.nextInt();
                money = cin.nextInt();
                map.put(i, new Ore(people, money));
            }
            int num = cin.nextInt();
            System.out.println(DP(num, map, n - 1));
        }
    }

    public static int DP(int num, HashMap<Integer, Ore> map, int index) {
        //map.get(index);
        if (index > 0) {
            if (num < map.get(index).getPeople()) {//当前剩下的人不足够挖这个矿，往下找
                return DP(num, map, index - 1);
            }
            int yes = map.get(index).getMoney() + DP(num - map.get(index).getPeople(), map, index - 1);
            //挖当前矿，得到的矿是当前矿加上以前挖的矿，人数耗费
            int no = DP(num, map, index - 1);//不挖当前矿，往下找
            if (yes > no) {
                // System.out.println(map.get(index).getMoney()+"---"+map.get(index).getPeople());
                return yes;
            } else return no;
        } else if (num >= map.get(index).getPeople()) {
            return map.get(index).getMoney();
        } else {
            return 0;
        }
    }
}

class Ore {
    private int people;
    private int money;

    Ore(int people, int money) {
        this.people = people;
        this.money = money;
    }

    public int getPeople() {
        return people;
    }

    public int getMoney() {
        return money;
    }
}


