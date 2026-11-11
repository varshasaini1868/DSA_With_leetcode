
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        int min = Math.min(need1, need2);
        int max = Math.max(need1, need2);

       
        long option1 = (long) min * Math.min(costBoth, cost1 + cost2)
                     + (long) (max - min) * Math.min(costBoth, 
                                                     need1 > need2 ? cost1 : cost2);

        
        long option2 = (long) max * costBoth;

       
        long option3 = (long) need1 * cost1 + (long) need2 * cost2;

        return Math.min(option1, Math.min(option2, option3));
    }
}
