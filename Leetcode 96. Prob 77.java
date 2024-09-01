class Solution {
    public int numTrees(int n) {
         int[] A = new int[n + 1];

        // Base cases
        A[0] = 1;
        A[1] = 1;

        // Fill G[i] for i = 2 to n using the recurrence relation
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                A[i] += A[j - 1] * A[i - j];
            }
        }

        // The final answer is G[n]
        return A[n];
    }
}

        
    