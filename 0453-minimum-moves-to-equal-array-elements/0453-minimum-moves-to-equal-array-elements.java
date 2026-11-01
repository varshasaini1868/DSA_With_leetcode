class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        int moves = 0;
        int n = nums.length;
        
        for(int i = 0; i<=n-1;i++){
            if(min>nums[i]){
                min = nums[i];
            }
        }
        for(int i = 0; i<=n-1; i++){
            moves = moves + (nums[i]-min);
        }
        return moves;
    }
}