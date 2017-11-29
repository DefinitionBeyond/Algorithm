package data_structure.Linklist.Sort;

public class MergingSort {
    public static void main(String[] args) {
        int[] a = {6, 5, 3, 1, 8, 7, 2, 4};
    }
    public int[] MSorted(int[] a,int[] Sort,int start,int end){
        int mid;
        int Sort2[] = new int[a.length+1];
        if(start == end){
            Sort[start] = a[start];
        }
        else {
            mid = (start+end)/2;
            MSorted(a,Sort2,start,mid);
            MSorted(a,Sort2,mid,end);
            Merge(Sort2,Sort,start,mid,end);
        }
        return a;
    }

    private void Merge(int[] sort2, int[] sort, int start, int mid, int end) {
        for(int i = mid+1,k=start;start<=mid&&i<=end;k++){
            if(sort2[start]<sort2[i]){
             sort[k] = sort2[start++];
            }else {
                sort[k] = sort2[i++];
            }
        }
        if(start<mid){
            for(int l =0 ; l<mid;l++){
//                sort[k+l]
            }
        }
    }

    public void print(int a[]){
        for (int i = 0 ; i < a.length ;i++){
            System.out.print(a[i]+"  ");
        }
    }
}
