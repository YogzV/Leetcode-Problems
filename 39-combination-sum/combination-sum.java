class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        helper(res,candidates,0,target,currList);
        return res;
    }

    public int helper(List<List<Integer>> res,int[] arr,int ind,int target,List<Integer> currList){

        if(target == 0){
            res.add(currList);
            return -1;
        }
        if(target < 0){
            return -1;
        }
        if(ind >= arr.length ){
            return 0;
        }
        
        List<Integer> list = new ArrayList<>(currList);
        for(int i=arr[ind];i<=target;i+=arr[ind]){
            list.add(arr[ind]);
           if(helper(res,arr,ind+1,target-i,list) == -1) 
             break;

        }

        helper(res,arr,ind+1,target,currList);
        return 0;
    }
}