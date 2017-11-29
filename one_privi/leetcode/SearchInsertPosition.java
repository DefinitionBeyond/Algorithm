package one_privi.leetcode;

public class SearchInsertPosition {
    public static void main(String[] args) {
       int []a = {};
        System.out.println(new SearchInsertPosition().searchInsert(a,2));
    }
    public int searchInsert(int[] nums, int target) {
//        int len = nums.length-1;
//        boolean flag=false;
        if(nums.length==0){
            return 0;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]>target||nums[i]==target){
                return i;
            }
            else if (i == nums.length-1){
                return nums.length;
            }
        }
        return 0;
    }
}
