class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int i,j;
        int size = strs.length;
        int[] ones = new int[size];
        int[] zeros = new int[size];
        int[][][] dp = new int[m+1][n+1][size];
        for(i=0;i<m+1;i++)
        {
            for(j=0;j<n+1;j++){
                Arrays.fill(dp[i][j],-1);
                
            }
        }
        for(i=0;i<size;i++)
        {
            int len = strs[i].length();
            for(j=0;j<len;j++)
            {
                if(strs[i].charAt(j) == '1')
                 ones[i]++;
                else
                 zeros[i]++;
            }
        }
        

        return findMax(ones,zeros,m,n,0,dp);
     }

     public static int findMax(int[] ones,int[] zeros,int maxZero,int maxOne,int ind,int[][][] dp){
   
       if(ind == ones.length)
        return 0;
       if(dp[maxZero][maxOne][ind] != -1)
        return dp[maxZero][maxOne][ind];

       int notTake = findMax(ones,zeros,maxZero,maxOne,ind+1,dp);

       int take = 0;
       int zero = zeros[ind];
       int one = ones[ind];
       if(one<= maxOne && zero<= maxZero)
       {
        take = 1 + findMax(ones,zeros,maxZero-zero,maxOne-one,ind+1,dp);
       }
      

       return dp[maxZero][maxOne][ind] = Math.max(take,notTake);
            
     }
}