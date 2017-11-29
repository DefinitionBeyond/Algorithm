package one_privi.leetcode;

public class RemoveElement {
    public static void main(String[] args) {
        int[] a= {3,2,2,3};
        System.out.println(new RemoveElement().removeElement(a,3));
    }
    public int removeElement(int[] nums, int val) {
        int t = 0;
        for(int a:nums){
            if (a != val) nums[t++] = a;
        }
        return t;
    }
}
