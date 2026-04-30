class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][k+1];

        int i,j;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        
        dp[0][0][0] = 0;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){

                for(int c = 0;c<=k;c++){
                    if(dp[i][j][c] == -1) continue;

                    if(j+1 < n){
                       int score = grid[i][j+1];
                       int newScore = dp[i][j][c] + score;
                       int newCost = c + ((score==0)? 0:1) ;
                       
                       if(newCost <= k){
                        dp[i][j+1][newCost] = Math.max(dp[i][j+1][newCost],newScore);
                       }
                         
                    }

                    if(i+1 < m){
                       int score = grid[i+1][j];
                       int newScore = dp[i][j][c] + score;
                       int newCost = c + ((score==0)? 0:1) ;
                       
                       if(newCost <= k){
                        dp[i+1][j][newCost] = Math.max(dp[i+1][j][newCost],newScore);
                       }
                    }
                }
            }
        }
        int ans = -1;
        for(i = 0;i<k+1;i++){
            ans = Math.max(ans,dp[m-1][n-1][i]);
        }
        return ans;
    }
}