class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] ans = new int[size];
        ans[0] = 1;
        for(int i = 1;i<size;i++)
        {
            ans[i] = ans[i-1] * nums[i-1];
        }
        int prev = 1;
        for(int i = size-2;i>=0;i--)
        {
            prev = prev * nums[i+1];
            ans[i] = prev * ans[i];
        }
        return ans;
    
    }
}