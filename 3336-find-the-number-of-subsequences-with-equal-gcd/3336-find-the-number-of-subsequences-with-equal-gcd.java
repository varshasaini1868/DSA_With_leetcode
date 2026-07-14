class Solution {

    static final int MOD = 1_000_000_007;
    Long[][][] memo;
    int[] nums;
    int n;
    public int subsequencePairCount(int[] nums) {
         this.nums = nums;
        this.n = nums.length;

        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        memo = new Long[n + 1][max + 1][max + 1];

        return (int) dfs(0, 0, 0);
    }

    private long dfs(int idx, int g1, int g2) {
        if (idx == n) {
            return (g1 != 0 && g1 == g2) ? 1 : 0;
        }

        if (memo[idx][g1][g2] != null) {
            return memo[idx][g1][g2];
        }

        long ans = 0;

    
        ans = (ans + dfs(idx + 1, gcd(g1, nums[idx]), g2)) % MOD;

    
        ans = (ans + dfs(idx + 1, g1, gcd(g2, nums[idx]))) % MOD;

    
        ans = (ans + dfs(idx + 1, g1, g2)) % MOD;

        return memo[idx][g1][g2] = ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}