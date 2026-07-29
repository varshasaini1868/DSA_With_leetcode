class Solution {

    private static final long MAX = 1000001;

    public String smallestPalindrome(String s, int k) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                mid = (char) ('a' + i);
                freq[i]--;
                break;
            }
        }

        int[] half = new int[26];
        int len = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            len += half[i];
        }

        if (count(half) < k) {
            return "";
        }

        StringBuilder left = new StringBuilder();

        for (int i = 0; i < len; i++) {

            for (int j = 0; j < 26; j++) {

                if (half[j] == 0)
                    continue;

                half[j]--;

                long ways = count(half);

                if (ways >= k) {
                    left.append((char) ('a' + j));
                    break;
                } else {
                    k -= ways;
                    half[j]++;
                }
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        if (mid == 0)
            return left.toString() + right;

        return left.toString() + mid + right;
    }

    private long count(int[] half) {

        int total = 0;

        for (int x : half)
            total += x;

        long ans = 1;

        for (int i = 0; i < 26; i++) {

            ans *= nCr(total, half[i]);

            if (ans >= MAX)
                return MAX;

            total -= half[i];
        }

        return ans;
    }

    private long nCr(int n, int r) {

        if (r > n)
            return 0;

        r = Math.min(r, n - r);

        long ans = 1;

        for (int i = 1; i <= r; i++) {

            ans = ans * (n - i + 1) / i;

            if (ans >= MAX)
                return MAX;
        }

        return ans;
    }
}