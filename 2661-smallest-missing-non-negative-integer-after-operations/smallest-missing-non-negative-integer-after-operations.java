class Solution {
    public int findSmallestInteger(int[] nums, int value) { 
        int i;
        HashMap<Integer,Integer> hmap = new HashMap<>();

        for(i=0;i<nums.length;i++)
        {
            if(nums[i] < 0)
            {
                nums[i] =nums[i]%value + value;
            }
            nums[i] %= value;
            hmap.merge(nums[i],1,Integer::sum);
        }
         i = 0;
        while(hmap.computeIfPresent(i%value,(k,v)-> v>0 ? v-1 : null) !=null)
        {
          i++;
           
        }
        return i;
    }
}