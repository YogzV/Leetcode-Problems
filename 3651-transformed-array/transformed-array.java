class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int size = nums.length;
        int[] ans = new int[size];
        for(int i=0;i<size;i++)
        {
            if(nums[i] == 0){
                ans[i] = nums[i];
            }else{
                ans[i] = nums[(i+ nums[i]%size + size) % size];
            }
                 
                 
        }

        return ans;
    }
}