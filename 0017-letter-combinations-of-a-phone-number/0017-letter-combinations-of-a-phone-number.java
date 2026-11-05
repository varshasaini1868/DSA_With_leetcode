import java.util.*;

class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        result.add("");

        for (int i = 0; i < digits.length(); i++) {

            String letters = map[digits.charAt(i) - '0'];

            List<String> temp = new ArrayList<>();

            for (String s : result) {
                for (int j = 0; j < letters.length(); j++) {

                    temp.add(s + letters.charAt(j));
                }
            }

            result = temp;
        }

        return result;
    }
}