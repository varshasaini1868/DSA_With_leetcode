class Solution {
    public String smallestPalindrome(String s) {
         int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder half = new StringBuilder();
        String mid = "";

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                mid = String.valueOf((char) (i + 'a'));
            }

            for (int j = 0; j < freq[i] / 2; j++) {
                half.append((char) (i + 'a'));
            }
        }

        String firstHalf = half.toString();
        String secondHalf = half.reverse().toString();

        return firstHalf + mid + secondHalf;
    }
}