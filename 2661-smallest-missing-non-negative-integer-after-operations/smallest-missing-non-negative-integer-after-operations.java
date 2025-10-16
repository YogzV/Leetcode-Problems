class Solution {
    public int findSmallestInteger(int[] nums, int value) { 
        int i;
        int len = nums.length;
        HashMap<Integer,Integer> hmap = new HashMap<>();

        for(i=0;i<len;i++)
        {
            if(nums[i] < 0)
            {
                nums[i] = nums[i]%value + value;
            }
            nums[i] = nums[i] % value;
            hmap.merge(nums[i],1,Integer::sum);
        }
        int ans = 0;
        while(hmap.computeIfPresent(ans%value,(k,v)-> v>0 ? v-1 : null) !=null)
        {
          ans++;
           
        }
        return ans;
    }
}