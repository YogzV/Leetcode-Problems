class Solution {

   
    public boolean canPartition(int[] nums) {
       
        int target = 0;
        for(int num : nums){
            target += num;
        }
           
        if((target&1) == 1)
         return false;
        
         
        target /= 2;

       Boolean[][] memo = new Boolean[nums.length][target+1];
       
        
        return recur(memo,target,nums,0);
        
    }

    public boolean recur(Boolean[][] memo,int target,int[] nums,int ind){
        if(target == 0)
         return true;
        
        if(ind == nums.length || target<0)
          return false;
        
        if(memo[ind][target] != null){
            return memo[ind][target];
        }

        return memo[ind][target] = (recur(memo,target-nums[ind],nums,ind+1) || recur(memo,target,nums,ind+1));
    }
}