import java.util.Arrays;

class Solution {
    // Modulo value as answer may be large
    private static final int MOD = 1000000007;

    private static final int[][] moves = {
        {4, 6},    // 0
        {6, 8},    // 1
        {7, 9},    // 2
        {4, 8},    // 3
        {0, 3, 9}, // 4
        {},        // 5 (knight cannot move to 5)
        {0, 1, 7}, // 6
        {2, 6},    // 7
        {1, 3},    // 8
        {2, 4}     // 9
    };
    
    public int knightDialer(int n) {
        // Base case: if n == 1, we can just place the knight on any of the 10 digits
        if (n == 1) return 10;
        
        // dp[i][j]: number of distinct phone numbers of length i ending at digit j
        int[][] dp = new int[n][10];
        
        // Initialize dp for the first row (length 1), all digits can start with 1 number
        for (int j = 0; j <= 9; j++) {
            dp[0][j] = 1;
        }
        
        // Fill the dp array for each step
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 9; j++) {
                // For each digit j, check where the knight can jump from
                for (int move : moves[j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][move]) % MOD;
                }
            }
        }
        
        // Sum up all possibilities for the last step (dp[n-1][j])
        int result = 0;
        for (int j = 0; j <= 9; j++) {
            result = (result + dp[n - 1][j]) % MOD;
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution kd = new Solution();
        
        // Example input
        int n = 1;
        System.out.println("Number of distinct phone numbers of length " + n + ": " + kd.knightDialer(n));  // Output: 10
    }
}
