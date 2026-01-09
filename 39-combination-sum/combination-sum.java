class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        helper(res,candidates,0,target,currList);
        return res;
    }

    public void helper(List<List<Integer>> res,int[] arr,int ind,int target,List<Integer> currList){

        if(target == 0){
            res.add(new ArrayList(currList));
            return;
        }
        if(target < 0 || ind >= arr.length){
            return;
        }

       currList.add(arr[ind]);
       helper(res,arr,ind,target-arr[ind],currList);
       currList.remove(currList.size()-1);
       helper(res,arr,ind+1,target,currList);
        return;
    }
}