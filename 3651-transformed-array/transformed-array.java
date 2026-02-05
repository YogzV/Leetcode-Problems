class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int size = nums.length;
        int[] ans = new int[size];
        for(int i=0;i<size;i++)
        {
          ans[i] = nums[(i+size + nums[i]%size) % size];           
        }

        return ans;
    }
}