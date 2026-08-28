import java.util.*;

class Solution {
    public int[] decompressRLElist(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i += 2) {

            int freq = nums[i];
            int val = nums[i + 1];

            for (int j = 0; j < freq; j++) {
                list.add(val);
            }
        }

        // ArrayList ko int[] me convert karna
        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}