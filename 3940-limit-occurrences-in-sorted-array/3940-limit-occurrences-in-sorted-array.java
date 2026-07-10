class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        int count = 1;

        for (int i = 0; i < nums.length; i++) {

            if (i > 0) {
                if (nums[i] == nums[i - 1]) {
                    count++;
                } else {
                    count = 1;
                }
            }

            if (count <= k) {
                result.add(nums[i]);
            }
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}