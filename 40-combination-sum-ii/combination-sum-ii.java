class Solution {
    static List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        
        List<Integer> currList = new ArrayList<>();
        helper(candidates,target,0,currList);
        return res;
    }
    public void helper(int[] arr,int target,int ind,List<Integer> currList){
        if(target == 0){
            res.add(new ArrayList<>(currList));
            return;
        }

        if(target < 0 || ind >= arr.length){
            return;
        }

        currList.add(arr[ind]);
        helper(arr,target-arr[ind],ind+1,currList);
        currList.remove(currList.size() -1);

        
        int size = arr.length;
        while(ind+1<size && arr[ind] == arr[ind+1]){
            ind++;
        }
        helper(arr,target,ind+1,currList);

        return;
    }
}