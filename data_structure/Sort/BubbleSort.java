package data_structure.Sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {6,5,3,1,8,7,2,4};
        BubbleSort ans = new BubbleSort();
        ans.print(ans.Sorted(a));
        ans.print(ans.SortedFast1(a));
    }
    public int[] Sorted(int a[]){
        int l = a.length;
        for(int i =0 ; i < l ;i++){
            for (int j = i ;j < l ;j++){
                int t;
                if(a[i] > a[j]){
                    t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
        return a;
    }
    public int[] SortedFast1(int a[]){//优化
        int l = a.length;
        boolean flag = true;
        for(int i =0 ; i < l && flag ;i++){
            flag = false;
            for (int j = i ;j < l ;j++){
                int t;
                if(a[i] > a[j]){
                    t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                    flag = true;
                }
            }
        }
        return a;
    }
    
    public int[] SortedFast2(int[] a) {
        int l = a.length;
        for (int i = l - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
        return a;
    }
    
    public void print(int a[]){
        for (int i = 0 ; i < a.length ;i++){
            System.out.print(a[i]+"  ");
        }
    }
}
