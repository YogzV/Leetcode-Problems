class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return helper(dp,nums,0,n);
    }

    public int helper(int[] dp,int[] nums,int start,int n){

        if(start >= n)
         return 0;

        if(dp[start] != -1)
         return dp[start];
    
        int notPick = helper(dp,nums,start+1,n);

        int pick = nums[start] + helper(dp,nums,start+2,n);
        

        return dp[start] = Math.max(notPick,pick);
    }
}