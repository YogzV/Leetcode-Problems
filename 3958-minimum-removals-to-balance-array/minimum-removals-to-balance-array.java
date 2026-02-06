class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        
        int left = 0;
        int size = nums.length;
        int maxAns = 0;
        
        for(int right = 0;right <size;right++){
            while(left < right && (long)nums[left] * k < nums[right])
             left++;
            
            maxAns = Math.max(maxAns,right-left+1);
        }
        

        return size-maxAns;

    }
}