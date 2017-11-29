package two_privi.zuochengyun;

import java.util.LinkedList;
import java.util.Random;

public class obtainWindowMax {
    public static void main(String[] args) {
        Random random = new Random();
        int []a = new int [10];
        for(int i = 0 ; i < 10 ;i++){
            a[i]=random.nextInt(100)%(100-1+1)+1;
        }

       obtainWindowMax O = new obtainWindowMax();
       O.print(O.deal(a,3));
    }
    private void print(int arr[]){
        for(int i = 0 ; i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    private int[] deal(int arr[],int w)
    {
        if(arr == null||w<1||arr.length<w){//不合格数据
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int []res = new int [arr.length-w+1];
        int index = 0;
        for(int i =0 ; i < arr.length ; i++){
            while(!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[i]){//arr[i]大于队尾元素，队尾出队
                qmax.pollLast();
            }
            qmax.addLast(i);//入队
            if(qmax.peekFirst()==i-w){//对于失效的元素也要出队
                qmax.pollFirst();
            }
            if(i>=w-1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
