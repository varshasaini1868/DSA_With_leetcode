
import java.util.Arrays;

class Solution {

    public int minimumChanges(String s, int k) {
        int n = s.length();
        int INF = 1000000;

        // Step 1: Precompute minimum changes for every substring
        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len <= n; i++) {

                int j = i + len - 1;
                cost[i][j] = INF;

                // Try all valid divisors of substring length
                for (int d = 1; d < len; d++) {

                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    // Check palindrome condition for each group
                    for (int r = 0; r < d; r++) {

                        int left = i + r;
                        int right = i + r + ((len - 1 - r) / d) * d;

                        while (left < right) {

                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    cost[i][j] = Math.min(cost[i][j], changes);
                }
            }
        }

        // Step 2: Dynamic Programming
        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        // Divide string into exactly k substrings
        for (int parts = 1; parts <= k; parts++) {

            for (int end = 2 * parts; end <= n; end++) {

                for (int start = 2 * (parts - 1);
                     start <= end - 2; start++) {

                    if (dp[parts - 1][start] == INF) {
                        continue;
                    }

                    dp[parts][end] = Math.min(
                        dp[parts][end],
                        dp[parts - 1][start] + cost[start][end - 1]
                    );
                }
            }
        }

        return dp[k][n];
    }
}

