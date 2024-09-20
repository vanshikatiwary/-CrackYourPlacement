class Solution {
    public int fun(int[] arr, int i , int prev, int[][] dp){
        if(i==arr.length){
            return 0;
        }
        if(dp[i][prev+1]!= -1){
            return dp[i][prev+1];
        }
        int take =0;
        if(prev == -1 || arr[i]>arr[prev]){
            take = 1  + fun(arr,i +1, i,dp);
        }
        int notTake = fun(arr, i+1, prev,dp);
        return dp[i][prev+1]=Math.max(take, notTake);
    }
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 2];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
   
        return fun(nums,0,-1,dp);
    }
}