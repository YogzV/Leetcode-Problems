class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i : nums){
            hmap.merge(i,1,Integer::sum);
        }
        while(hmap.containsKey(original)){
            original *=2;
        }
        return original;
    }
}