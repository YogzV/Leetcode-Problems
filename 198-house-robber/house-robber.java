class Solution {
    public int rob(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        int next2 = nums[n-1];
        int next1 = 0;
        int curr = 0;
        for(int i = n-2;i>=0;i--){
                if(i == n-2){
                    next1 = Math.max(nums[i],next2);
                }else{
                    curr = Math.max(nums[i] + next2,next1);
                    next2 = next1;
                    next1 = curr;
                }
                 
        }

        return next1;
    }
}