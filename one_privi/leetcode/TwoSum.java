package one_privi.leetcode;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int a[] = {1,3,7,8,15};
        int []ans=new TwoSum().twoSum(a,9);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
    public int[] twoSum(int[] nums, int target) {//找出数组中两个相加等于目标值的下标
        int []res = new int [2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0 ; i< nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i =0 ; i< nums.length;i++) {
            int t = target - nums[i];
            if(map.containsKey(t)&&map.get(t)!=i) {
               return new int[]{i,map.get(t)};
            }
        }
        return res;
    }
}
