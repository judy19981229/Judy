package text;

public class LeetCode4 {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] nums = new int[length1 + length2];
        double result;
        int l = 0;
        int l1 = 0;
        int l2 = 0;
        while(l1 < length1 && l2 < length2){
            if(nums1[l1] < nums2[l2]){
                nums[l++] = nums1[l1++];
            }else{
                nums[l++] = nums2[l2++];
            }
        }
        while(l1 < length1){
            nums[l++] = nums1[l1++];
        }
        while(l2 < length2){
            nums[l++] = nums2[l2++];
        }
        int length = nums.length;
        if(length % 2 == 1){
            result = nums[length / 2];
        }else{
            result = (nums[length / 2 - 1] + nums[length / 2]) / 2.0;
        }
        return result;
    }
}
