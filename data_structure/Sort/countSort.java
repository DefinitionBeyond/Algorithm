package data_structure.Sort;


/**
 * 计数排序 不是基于比较得出的 ，而是基于桶排序的思想
 * <p>
 * 整个数组有几个小于k的元素 ， 那么k就是第k+1大
 * <p>
 * 即把k插入中间数组的第k个位置就可以
 */
public class countSort {
    public static void main(String[] args) {
        int[] a = {6, 5, 3, 1, 8, 7, 2, 4};
        countSort c = new countSort();
        c.Sort(a);
        c.print(a);
    }

    public void print(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
    }

    public void Sort(int[] nums) {
        int[] temp = new int[nums.length];
        int count;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;//统计比nums[i]小的元素个数
                }
            }
            temp[count] = nums[i];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }
}
