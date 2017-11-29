package two_privi.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchForARange {
    public static void main(String[] args) {
        int[] a = {1};
        int[] r = new SearchForARange().searchRange(a, 1);
        for (Object o : r) {
            System.out.println(o);
        }

    }

    public int[] searchRange(int[] nums, int target) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            List<Integer> list = new ArrayList<>();
            if (map.containsKey(nums[i])) {
                list = map.get(nums[i]);
                list.add(i);
            } else {
                list.add(i);
            }
            map.put(nums[i], list);
        }
        int[] res = new int[2];
        if (map.containsKey(target)) {
            Object[] o = map.get(target).toArray();
            res[0] = (int)o[0];
            res[1] = (int)o[o.length-1];
            return res;
        } else {
            return new int[]{-1,-1};
        }
    }
}
