class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i : nums)
        {
            if(hmap.containsKey(i))
            {
                return true;
            }
            hmap.put(i,1);
        }
        return false;
    }
}