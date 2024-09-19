class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;    // Number of rows
        int n = grid[0].length; // Number of columns

        // Create a dp array to store the minimum sum to each cell
        int[][] dp = new int[m][n];

        // Initialize the top-left corner with the starting point value
        dp[0][0] = grid[0][0];

        // Initialize the first row (can only come from the left)
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Initialize the first column (can only come from above)
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Fill the rest of the dp array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // The result is the value at the bottom-right corner
        return dp[m - 1][n - 1];
    }
}

        
   