class Solution {
    public int climbStairs(int n) {
        
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(dp,n,0);
    }

    public int helper(int[] dp,int n,int start){
        if(start > n)
         return 0;
        if(start == n)
         return 1;
        if(dp[start] != -1)
         return dp[start];
        
        int way1 = helper(dp,n,start+1);
        int way2 = helper(dp,n,start+2);


        return dp[start] = way1 + way2 ;
    }
}