class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(res,0,nums,curr);
        return res;
    }

    public void helper(List<List<Integer>> res,int ind,int[] nums,List<Integer> curr)
    {
        if(ind >= nums.length){
            res.add(curr);
            return;
        }
        List<Integer> list = new ArrayList<>(curr);
        list.add(nums[ind]);
        helper(res,ind+1,nums,curr);
        helper(res,ind+1,nums,list);
        return;
    }
}