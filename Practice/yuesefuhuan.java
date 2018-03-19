package Practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author liutao
 * @date 2018/3/19  13:14
 * <p>
 * 约瑟夫环问题
 */
public class yuesefuhuan {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int i;
        while (cin.hasNext()) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            int a[] = new int[n];
            Queue<String> queue = new LinkedList<String>();
            String s;
            for (i = 0; i < n; i++) {
                queue.offer(i + "");
            }
            //  for(String q: queue)
            //{
            //  System.out.println(q);
            // }
            int cnt = 0;
            String S;
            while (queue.size() > 1) {
                ++cnt;
                if (cnt % m == 0) {
                    queue.poll();
                    cnt = 0;
                } else {
                    S = queue.peek();
                    queue.add(S);
                    queue.remove();
                }
            }
            System.out.println();
            System.out.println(queue.peek());
        }
    }
}
