class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> hset = new HashSet<>();
        int size = nums.length;
        for(int i =0;i<size;i++){
            hset.add(nums[i]);
        }
        while(hset.contains(original)){
            original *=2;
        }
        return original;
    }
}