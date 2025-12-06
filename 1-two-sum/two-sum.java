class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int len = nums.length;
        for(int i = 0;i<len;i++)
        {
            int val = target - nums[i];
            if(hmap.containsKey(val))
             return new int[]{hmap.get(val),i};
            
            hmap.put(nums[i],i);
        }
        return new int[]{};
    }
}