class Solution {
    public int minimumCost(int[] nums) {
       
        int first = Math.min(nums[1],nums[2]);
        int second = Math.max(nums[1],nums[2]);
        for(int i=3;i<nums.length;i++){
            if(nums[i] <= first)
            {
                int temp = first;
                first = nums[i];
                second = temp;
            }else if(nums[i] < second){
                second = nums[i];
            }
        }

        return nums[0] + first + second;
    }
}