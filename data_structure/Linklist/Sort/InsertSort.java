package data_structure.Linklist.Sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] a = {6,5,3,1,8,7,2,4};
        InsertSort in = new InsertSort();
        in.print(in.Sorted(a));
    }
    public int[] Sorted(int[] a){
        int l = a.length;
        int t=0,j =0 ;
        for(int i =1 ; i< l ;i++){

            if( a[i] < a[i-1]) {
                t = a[i];//设置哨兵
//                System.out.println(t+"+++=======");
                for (j = i - 1; j>=0&&a[j] > t; j--)
                    a[j + 1] = a[j];
//
                a[j+1] = t;
//                print(a);
            }
        }
//        System.out.println();
        return a;
    }
    public void print(int a[]){
        for (int i = 0 ; i < a.length ;i++){
            System.out.print(a[i]+"  ");
        }
    }
}
