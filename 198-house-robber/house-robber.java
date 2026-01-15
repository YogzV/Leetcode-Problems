class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        

        dp[n-1] = nums[n-1];
        for(int i = n-2;i>=0;i--){
            if(i == n-2){
                dp[i] = Math.max(nums[i],dp[i+1]);
            }else{
                dp[i] = Math.max(nums[i] + dp[i+2],dp[i+1]);
            }
        }

        return dp[0];
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