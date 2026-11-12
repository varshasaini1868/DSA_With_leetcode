class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = 0;

        // Find maximum candies
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }

        List<Boolean> result = new ArrayList<>();

        // Check each kid
        for (int i = 0; i < candies.length; i++) {

            if (candies[i] + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}