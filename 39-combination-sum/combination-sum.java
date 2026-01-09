class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        helper(res,candidates,0,target,0,currList);
        return res;
    }

    public int helper(List<List<Integer>> res,int[] arr,int ind,int target,int curr,List<Integer> currList){

        if(curr == target){
            res.add(currList);
            return -1;
        }
        if(curr > target){
            return -1;
        }
        if(ind >= arr.length ){
            return 0;
        }
        
        List<Integer> list = new ArrayList<>(currList);
        for(int i=curr+arr[ind];i<=target;i+=arr[ind]){
            list.add(arr[ind]);
           if(helper(res,arr,ind+1,target,i,list) == -1) 
             break;

        }

        helper(res,arr,ind+1,target,curr,currList);
        return 0;
    }
}