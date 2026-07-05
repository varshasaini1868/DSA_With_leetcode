class Solution {
    public boolean isPossibleToSplit(int[] nums) {
         Arrays.sort(nums);

        int count = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                count++;

                if (count > 2) {
                    return false;
                }
            } else {
                count = 1;
            }
        }

        return true;
    }
}