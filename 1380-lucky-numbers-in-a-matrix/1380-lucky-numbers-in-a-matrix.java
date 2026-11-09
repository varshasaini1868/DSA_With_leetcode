
import java.util.*;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {

            // Find minimum element in current row
            int min = matrix[i][0];
            int col = 0;

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    col = j;
                }
            }

            // Check whether it is maximum in its column
            boolean flag = true;

            for (int k = 0; k < m; k++) {
                if (matrix[k][col] > min) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                result.add(min);
            }
        }

        return result;
    }
}
