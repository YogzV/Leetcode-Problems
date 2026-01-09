class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(nums,0,curr);
        return res;
    }

    public void helper(int[] nums,int ind,List<Integer> curr){
        if(ind == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[ind]);
        helper(nums,ind+1,curr);
        curr.remove(curr.size() - 1);

        int size = nums.length;
        while(ind+1<size && nums[ind]==nums[ind+1])
          ind++;

        helper(nums,ind+1,curr);
        return;
    }
}