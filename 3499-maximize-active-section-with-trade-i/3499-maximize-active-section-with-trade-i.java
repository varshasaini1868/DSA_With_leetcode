class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
         int originalOnes = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') originalOnes++;
        }

        String t = "1" + s + "1";

        ArrayList<Character> type = new ArrayList<>();
        ArrayList<Integer> len = new ArrayList<>();

        int i = 0;
        while (i < t.length()) {
            char ch = t.charAt(i);
            int j = i;
            while (j < t.length() && t.charAt(j) == ch) {
                j++;
            }
            type.add(ch);
            len.add(j - i);
            i = j;
        }

        int ans = originalOnes;

        for (int k = 2; k < type.size() - 1; k += 2) {
            int gain = len.get(k - 1) + len.get(k + 1);
            ans = Math.max(ans, originalOnes + gain);
        }

        return ans;
    }
}