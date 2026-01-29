class Solution {
    HashMap<String,Integer> memo;
    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return recur(nums,target,0);
        
    }

    public int recur(int[] nums,int target,int ind){
        if(ind == nums.length){
            if(target == 0)
             return 1;
            
            return 0;
        }
        String key = ind + "," + target;
        if(memo.containsKey(key))
         return memo.get(key);

        int ans1 = recur(nums,target-nums[ind],ind+1) ;
        int ans2 = recur(nums,target+nums[ind],ind+1);

        memo.put(key,ans1 + ans2);

        return ans1 + ans2;
    }
}