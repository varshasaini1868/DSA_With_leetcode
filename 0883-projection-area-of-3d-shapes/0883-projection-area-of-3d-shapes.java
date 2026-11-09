
class Solution {
    public int projectionArea(int[][] grid) {

        int n = grid.length;
        int top = 0;
        int front = 0;
        int side = 0;

        for (int i = 0; i < n; i++) {

            int maxRow = 0;
            int maxCol = 0;

            for (int j = 0; j < n; j++) {

                // Top view
                if (grid[i][j] > 0) {
                    top++;
                }

                // Front view
                maxRow = Math.max(maxRow, grid[i][j]);

                // Side view
                maxCol = Math.max(maxCol, grid[j][i]);
            }

            front += maxRow;
            side += maxCol;
        }

        return top + front + side;
    }
}
