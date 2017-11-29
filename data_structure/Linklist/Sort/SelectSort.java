package data_structure.Linklist.Sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] a = {6,5,3,1,8,7,2,4};
        SelectSort ans =  new SelectSort();
        ans.print(ans.Sorted(a));
    }

    public int[] Sorted(int []a){
        int l = a.length;
        int min,t;
         for(int i = 0 ; i< l-1 ;i++){
             min = i;
             for(int j = i+1 ; j<l ; j++){
                 if(a[min] > a[j]){
                     min = j;
                 }
             }
             if(i!= min){
                 t = a[i];
                 a[i] = a[min];
                 a[min] = t;
             }
//             System.out.println(a[min]);
         }
        return a;
    }

    public void print(int a[]){
        for (int i = 0 ; i < a.length ;i++){
            System.out.print(a[i]+"  ");
        }
    }
}
