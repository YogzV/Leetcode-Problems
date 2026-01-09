class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        helper(res,candidates,0,target,currList);
        return res;
    }

    public void helper(List<List<Integer>> res,int[] arr,int ind,int target,List<Integer> currList){

        if(target == 0){
            res.add(currList);
            return;
        }
        if(target < 0 || ind >= arr.length){
            return;
        }
        
       List<Integer> list = new ArrayList<>(currList);

       list.add(arr[ind]);
       helper(res,arr,ind,target-arr[ind],list);
       helper(res,arr,ind+1,target,currList);
        return;
    }
}