class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(helper(dp,n,0,cost),helper(dp,n,1,cost));
    }

    public int helper(int[] dp,int n ,int start,int[] cost){
       if(start >= n)
        return 0;

      if(dp[start] != -1)
       return dp[start];

       int way1 =  cost[start] + helper(dp,n,start+1,cost);
       int way2 =  cost[start] + helper(dp,n,start+2,cost);

       return dp[start] = Math.min(way1,way2);

    }
}