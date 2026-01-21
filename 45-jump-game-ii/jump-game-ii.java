class Solution {
  
    HashMap<Integer,Integer> memo = new HashMap<>();
    public int jump(int[] nums) {
        
        return recur(nums,0);
        
    }

    public int recur(int[] nums,int ind){
        if(ind >= nums.length - 1){
         return 0;
        }
        if(memo.containsKey(ind))
         return memo.get(ind);
        
        int min = Integer.MAX_VALUE;
        for(int i=ind+1;i<=ind+nums[ind];i++){
            int val = recur(nums,i); 
            if(val != Integer.MAX_VALUE){
                min = Math.min(min,1+val);
            }
        }
        
        memo.put(ind,min);
        return min;
    }
}