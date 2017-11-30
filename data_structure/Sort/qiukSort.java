package data_structure.Sort;

public class qiukSort {
    public static void main(String []args){
        int[] a = {6, 5, 3, 1, 8, 7, 2, 4};
       qiukSort q = new qiukSort();
        q.Qsort(a,0,a.length-1);
        q.print(a);
    }

    private  int partition(int[] a,int low,int high){
        int start = low;
        int end = high;
        int key = a[low];

        while(end>start){
            //从后往前比较
            while(end>start&&a[end]>=key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while(end>start&&a[start]<=key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        }
        return start;

    }
    public  void Qsort(int[] nums, int low, int high) {
        int k;
        if (low < high) {
            k = partition(nums, low, high);
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
            Qsort(nums, low, k - 1);
            Qsort(nums, k + 1, high);
        }
    }
    public void print(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
    }

}