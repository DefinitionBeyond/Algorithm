package three_privi.leetcode;

import java.util.Arrays;

public class MedianofTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {3,4};
        System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(a,b));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length,len2 = nums2.length,
                m = (len1+len2+1)/2,n=(len1+len2+2)/2;
        return (fatchKth(nums1,nums2,m)+fatchKth(nums1,nums2,n))/2.0;
    }

    private int fatchKth(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length,len2 = nums2.length;
        if(len1>len2) return fatchKth(nums2,nums1,k);//交换数组
        if(len1==0)return nums2[k-1];//只有一个数组，返回数组的第k个数
        if(k==1)return Math.min(nums1[0],nums2[0]);//两个数组总元素不超过2个
        int i = Math.min(len1, k / 2), j = Math.min(len2, k / 2);
        if (nums1[i - 1] > nums2[j - 1]) {//二分查找第k个元素
            return fatchKth(nums1, Arrays.copyOfRange(nums2, j, len2), k - j);
        } else {
            return fatchKth(Arrays.copyOfRange(nums1, i, len1), nums2, k - i);
        }
    }
}
