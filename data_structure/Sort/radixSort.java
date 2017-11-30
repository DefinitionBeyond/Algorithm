package data_structure.Sort;


/**
 * 基数排序的基础思想也是桶排序，unbelievable
 * <p>
 * 将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。
 * <p>
 * 然后，从最低位开始，依次进行一次排序。
 * 这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
 */
public class radixSort {
    public static void main(String[] args) {
        int[] a = {50, 3, 542, 745, 2014, 154, 63, 616};
        radixSort r = new radixSort();
        r.radixSort(a);
        r.print(a);
    }

    public void print(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
    }

    public void radixSort(int[] nums) {
        int max = getMax(nums);
        for (int i = 1; max / i > 0; i *= 10) {
            countSort(nums, i);
        }
    }

    private int getMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    /**
     * 对数组的某一位进行排序
     *
     * @param nums 数组名
     * @param exp  位：个十百千....位
     */
    private void countSort(int[] nums, int exp) {
        int[] output = new int[nums.length];    // 存储"被排序数据"的临时数组
        int[] buckets = new int[10];

        //把第exp位存入bukets中
        for (int i = 0; i < nums.length; i++)
            buckets[(nums[i] / exp) % 10]++;

        // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
        for (int i = 1; i < 10; i++)
            buckets[i] += buckets[i - 1];

        for (int i = nums.length - 1; i >= 0; i--) {
            output[buckets[(nums[i] / exp) % 10] - 1] = nums[i];
            buckets[(nums[i] / exp) % 10]--;
        }

        // 将排序好的数据赋值给nums[]
        for (int i = 0; i < nums.length; i++)
            nums[i] = output[i];
        buckets = null;
        output = null;
    }
}
