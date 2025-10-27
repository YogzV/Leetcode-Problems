class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        
       
        int ans = 0;
        int max = 0;
        for(int i : nums)
        {
            hmap.merge(i,1,Integer::sum);
            max = Math.max(max,hmap.get(i));
        }
        for(Integer in : hmap.keySet())
               if(hmap.get(in) == max)
                ans+= max;
               
        
        return ans;
    }
}