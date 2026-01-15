class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1)
         return nums[0];
    
        int n = nums.length;
        return Math.max(helper(nums,0,n-1),helper(nums,1,n));

    }

    public int helper(int[] nums,int start,int n){

        int rob1 = 0;
        int rob2 = 0;
        int curr = 0;
        for(int i = start ; i < n ;i++){
            curr = Math.max(nums[i] + rob1,rob2);
            rob1 = rob2;
            rob2 = curr; 
        }

        return curr;

       
    }
}