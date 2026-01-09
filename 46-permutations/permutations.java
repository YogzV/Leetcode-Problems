class Solution {
    public List<List<Integer>> permute(int[] nums) {
         
         if(nums.length == 0){
            return Arrays.asList(new ArrayList<>());
         }

        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> perms = permute(Arrays.copyOfRange(nums,1,nums.length));

        for(List<Integer> perm : perms){
            for(int i=0;i<=perm.size();i++){
                List<Integer> copy = new ArrayList<>(perm);
                copy.add(i,nums[0]);
                res.add(copy);
            }
        }
        return res;
    }
}