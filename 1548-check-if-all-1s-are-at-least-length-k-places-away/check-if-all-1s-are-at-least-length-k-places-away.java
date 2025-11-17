class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int i;
        int size = nums.length;
        int prev = -1;
        for(i=0;i<size;i++)
        {
           if(nums[i] == 1)
           {
                if(prev == -1)
                {
                    prev = i;
                }else
                {
                   if((i-prev-1) < k)
                    return false; 
                prev = i;
                }
           }
           
        }
        return true;
    }
}