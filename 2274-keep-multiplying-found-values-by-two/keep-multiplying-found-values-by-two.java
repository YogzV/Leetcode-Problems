class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> hset = new HashSet<>();
        int size = nums.length;
        for(int i =0;i<size;i++){
            hset.add(nums[i]);
        }
        while(true){
            if(hset.contains(original))
             original *=2;
             else
              break;
        }
        return original;
    }
}