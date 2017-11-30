package data_structure.Sort;

public class MergingSort {
    public static void main(String[] args) {
        int[] a = {6, 5, 3, 1, 8, 7, 2, 4};
        MergingSort msort = new MergingSort();

        msort.print(msort.MSort(a, 0, a.length - 1));

    }

    public  int[] MSort(int[] nums, int low, int high) {
        int mid = low + (high - low) / 2;
        if (low < high) {
            MSort(nums, low, mid);
            MSort(nums, mid + 1, high);
            Merge(nums, low, mid, high);
        }
        return nums;
    }

    private  void Merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }

    public void print(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
    }
}
