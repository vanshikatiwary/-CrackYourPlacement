class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            int count = 0;
            int num = i;
            
            // Count the number of 1's in the binary representation of i
            while (num > 0) {
                if (num % 2 == 1) {
                    count++;
                }
                num = num / 2; // Shift right by dividing by 2
            }
            
            ans[i] = count; // Store the count in the ans array
        }
        
        return ans;
    }
}
        
  