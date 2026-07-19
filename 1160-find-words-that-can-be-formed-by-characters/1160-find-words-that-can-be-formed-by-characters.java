class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            freq[chars.charAt(i) - 'a']++;
        }

        int sum = 0;

        for (String word : words) {
            int[] temp = new int[26];
            boolean good = true;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                temp[ch - 'a']++;

                if (temp[ch - 'a'] > freq[ch - 'a']) {
                    good = false;
                    break;
                }
            }

            if (good) {
                sum += word.length();
            }
        }

        return sum;
    }
}