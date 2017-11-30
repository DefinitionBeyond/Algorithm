package data_structure.Sort;

;

public class qiukSort {

    public static void main(String[] args) {
        int[] a = {6, 5, 3, 1, 8, 7, 2, 4};
    }

    public void Qsort(int[] nums, int low, int high) {
        int k;
        if (low < high) {
            k = partition(nums, low, high);
            Qsort(nums, low, k - 1);
            Qsort(nums, k + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int i = low ;
        int j = high;
        int mid = low+(high-low)>>>1;
        while (low<high){
            while()
        }
        return low;
    }

}