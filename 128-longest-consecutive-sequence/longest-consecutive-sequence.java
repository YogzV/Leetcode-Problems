class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i : nums)
        {
           hmap.put(i,1);     
        }
        int max = 0;
        for(int i : nums)
        {
            int val1 = i -1;
            int val2 = i+1;
            int cnt = 1;
           
            while(hmap.containsKey(val1))
            {
                hmap.remove(val1);
                val1--;
                cnt++; 
            }
            while(hmap.containsKey(val2))
            {
                hmap.remove(val2);
                val2++;
                cnt++; 
            }
            
            max = Math.max(cnt,max);
        }
        return max;
    }
}