class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hmap = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            int val = target - nums[i];
            if(hmap.containsKey(val))
            {
                return new int[]{hmap.get(val),i};
            }
            else
            {
                hmap.put(nums[i],i);
            }
        }
        return new int[]{};


    }
}