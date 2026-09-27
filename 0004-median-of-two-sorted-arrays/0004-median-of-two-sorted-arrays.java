import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length + nums2.length;

        int[] nums = new int[n];

        int k = 0;

        // Copy nums1
        for (int i = 0; i < nums1.length; i++) {
            nums[k] = nums1[i];
            k++;
        }

        // Copy nums2
        for (int i = 0; i < nums2.length; i++) {
            nums[k] = nums2[i];
            k++;
        }

        // Sort array
        Arrays.sort(nums);

        // If total length is odd
        if (n % 2 != 0) {
            return nums[n / 2];
        }

        // If total length is even
        else {
            int a = nums[n / 2 - 1];
            int b = nums[n / 2];

            return (a + b) / 2.0;
        }
    }
}