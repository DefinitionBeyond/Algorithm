package data_structure.Sort;


/**
 * 希尔排序的过程中也就是一个步长不是一直为1的插入排序，
 * <p>
 * 步长在排序的过程中不断调整
 * <p>
 * 但是最后一次的步长一定是1
 * <p>
 * 希尔排序性能的好坏取决于步长的选择
 * <p>
 * 选取步长最坏的情况，可以使过程达到O(n^2)级别
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] a = {6, 5, 3, 1, 8, 7, 2, 4};
        ShellSort s = new ShellSort();
        s.ShellSort(a);
        s.print(a);
    }

    public void ShellSort(int[] nums) {
        int t;
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < nums.length; i++) {
                int j = i;
                while (j - gap >= 0 && nums[j] < nums[j - gap]) {
                    //插入排序采用交换法
                    t = nums[j];
                    nums[j] = nums[j - gap];
                    nums[j - gap] = t;
                    j -= gap;
                }
            }
        }
    }

    public void print(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
    }
}
