class Solution {
    public List<Integer> intersection(int[][] nums) {
        
         List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums[0].length; i++) {

            int current = nums[0][i];
            boolean foundInAll = true;

            for (int j = 1; j < nums.length; j++) {

                boolean found = false;

                for (int k = 0; k < nums[j].length; k++) {
                    if (nums[j][k] == current) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    foundInAll = false;
                    break;
                }
            }

            if (foundInAll) {
                result.add(current);
            }
        }

        Collections.sort(result);
        return result;
    }
}