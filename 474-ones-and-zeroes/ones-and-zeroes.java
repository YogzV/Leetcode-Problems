class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int i,j;
        int size = strs.length;
        int[][] freq = new int[size][2];
        int[][][] dp = new int[m+1][n+1][size];
        
        for(i=0;i<m+1;i++)
            for(j=0;j<n+1;j++)
                Arrays.fill(dp[i][j],-1);   
            
        for(i=0;i<size;i++)
            for(j=strs[i].length()-1;j>=0;j--)
                freq[i][strs[i].charAt(j) == '1'? 1 : 0]++;
            
        return findMax(freq,m,n,0,dp);
     }

     public static int findMax(int[][] freq,int maxZero,int maxOne,int ind,int[][][] dp){
   
       if(ind == freq.length)
        return 0;
       if(dp[maxZero][maxOne][ind] != -1)
        return dp[maxZero][maxOne][ind];

       int notTake = findMax(freq,maxZero,maxOne,ind+1,dp);

       int take = 0;
       int zero = freq[ind][0];
       int one = freq[ind][1];

       if(one<= maxOne && zero<= maxZero)
         take = 1 + findMax(freq,maxZero-zero,maxOne-one,ind+1,dp);
       
       return dp[maxZero][maxOne][ind] = Math.max(take,notTake);
            
     }
}