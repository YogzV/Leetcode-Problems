class Solution {
    public int minimumOperations(int[] nums) {
        int i;
        int size = nums.length;
        int ans = 0;
        for(i = 0;i<size;i++)
        {
            int quo = nums[i]/3;
            ans += Math.min(nums[i]%3,3*(quo+1) - nums[i]);
        }
        return ans;
    }
}