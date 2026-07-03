class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
         int[] arr = new int[Math.min(nums1.length, nums2.length)];
        int i = 0, j = 0, k = 0;

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] == nums2[j]) {

                if (k == 0 || arr[k - 1] != nums1[i]) {
                    arr[k] = nums1[i];
                    k++;
                }

                i++;
                j++;

            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return Arrays.copyOf(arr, k);
    }
}