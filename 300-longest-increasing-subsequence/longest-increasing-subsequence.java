class Solution {

    int[][] memo;
   
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n][n];

        for(int[] row : memo)
         Arrays.fill(row,-1);

        return recur(nums,0,-1);
       
    }

    public int recur(int[] nums,int ind,int j){
        
        
        if(ind >= nums.length )
         return 0;

        if(j!=-1 && memo[ind][j] != -1)
         return memo[ind][j];
        
        int ans1 = (j==-1 || nums[j] < nums[ind])? 1+recur(nums,ind+1,ind) : 0;
        int ans2 = recur(nums,ind+1,j);
       
        int val = Math.max(ans1,ans2);
        if(j!= -1)
         memo[ind][j] = val;
         
        return val;
    }
}