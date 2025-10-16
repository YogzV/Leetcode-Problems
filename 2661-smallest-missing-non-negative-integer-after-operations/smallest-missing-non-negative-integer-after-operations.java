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
        while(true)
        {
          
           if(hmap.containsKey(ans%value)){
            if(hmap.get(ans%value) > 0)
            {
                hmap.merge(ans%value,-1,Integer::sum);
            }else{
                break;
            }
           }else{
            break;
           }
           ans++;
        }
        return ans;
    }
}