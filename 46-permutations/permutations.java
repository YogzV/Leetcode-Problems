class Solution {
      List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> perms = new ArrayList<>();
        helper(nums,new boolean[nums.length],perms);
        return res;
    }

    public void helper(int[] nums,boolean[] pick,List<Integer> perms){

          if(perms.size() == nums.length){
            res.add(new ArrayList<>(perms));
            return;
          }
        for(int i=0;i<nums.length;i++)
        {
            if(!pick[i]){
                perms.add(nums[i]);
                pick[i] = true;
                helper(nums,pick,perms);
                pick[i] = false;
                perms.remove(perms.size() -1);

            }
        }

        return;
    }
}