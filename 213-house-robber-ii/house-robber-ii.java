class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int ans1 = helper(dp,nums,0,n-1);
        Arrays.fill(dp,-1);
        int ans2 = helper(dp,nums,1,n);
        return Math.max(ans1,ans2);

    }

    public int helper(int[] dp,int[] nums,int start,int n){
        if(start >= n) 
         return 0;
        
        if(dp[start] != -1)
         return dp[start];

        return dp[start] = Math.max(nums[start] + helper(dp,nums,start+2,n) , helper(dp,nums,start+1,n));
    }
}