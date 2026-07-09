class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        Arrays.sort(nums);

        int expected = 1;

        for (int i = 0; i < nums.length; i++) {
            while (expected < nums[i]) {
                result.add(expected);
                expected++;
            }

            if (expected == nums[i]) {
                expected++;
            }
        }

        while (expected <= nums.length) {
            result.add(expected);
            expected++;
        }

        return result;
    }
}