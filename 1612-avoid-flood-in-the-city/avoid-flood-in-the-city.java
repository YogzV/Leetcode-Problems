class Solution {

    public int[] avoidFlood(int[] rains) {
    
    HashMap<Integer,Integer> hmap = new HashMap<>();
    int len = rains.length;
    int[] ans = new int[len];
    Arrays.fill(ans,1);
    int i;

    TreeSet<Integer> tset = new TreeSet<>();

    for(i=0;i<len;i++)
    {
        if(rains[i]==0)
        {
            tset.add(i);
        }
        else 
        {
            ans[i] = -1;
            if(hmap.containsKey(rains[i]))
            {
                Integer val = tset.ceiling(hmap.get(rains[i]));
                if(val == null)
                  return new int[0];
                ans[val] = rains[i];
                tset.remove(val);
            }
             hmap.put(rains[i],i); 
        }
    }
    return ans;
    }
}