package data_structure.Search;

/**
 * @author liutao
 * @date 2018/5/6  21:28
 */
public class BinSearch {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 9};
        System.out.println(test1(a, 4));
        System.out.println(test2(a, 4));
    }

    /**
     * 二分查找循环实现
     *
     * @param a 有序数组
     * @param k 查找元素
     * @return 索引
     */
    public static int test1(int[] a, int k) {
        int low = 0, high = a.length - 1, mid;
        while (low < high) {
            if (a[low] == k) {
                return low;
            }
            if (a[high] == k) {
                return high;
            }
            mid = (low + high) >> 1;
            if (a[mid] == k) {
                return mid;
            } else if (a[mid] < k && low <= high) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找递归实现
     *
     * @param a 有序数组
     * @param k 查找元素
     * @return 索引
     */
    public static int test2(int[] a, int k) {
        return binsearch(a, k, 0, a.length - 1);
    }

    /**
     * @param a    有序数组
     * @param k    查找元素
     * @param low  当前查找数组范围下界
     * @param high 当前查找数组范围上界
     * @return 索引
     */
    private static int binsearch(int[] a, int k, int low, int high) {
        if (k < a[0] || k > a[a.length - 1] || low > high) {
            return -1;
        }
        int mid = (low + high) >> 1;
        if (a[mid] < k) {
            return binsearch(a, k, mid + 1, high);
        } else if (a[mid] > k) {
            return binsearch(a, k, low, mid - 1);
        } else {
            return mid;
        }
    }
}
