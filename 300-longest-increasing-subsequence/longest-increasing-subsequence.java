class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 0;
        for(int i = n-1 ;i >=0 ;i--){
            int curr = 1;
            for(int j = i+1;j<n;j++){
                if(nums[i] < nums[j]){
                    curr = Math.max(curr,1+dp[j]);
                }
            }

            dp[i] = curr;
            max = Math.max(dp[i],max);
        }

        return max;
    }
}