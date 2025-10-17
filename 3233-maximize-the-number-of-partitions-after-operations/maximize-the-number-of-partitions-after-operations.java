class Solution {
    String s;
    int k;
    HashMap<Long,Integer> hmap = new HashMap<>();
    public int maxPartitionsAfterOperations(String s, int k) {
        this.k = k;
        this.s = s;
       return recur(0,0,1);
    }

    private int recur(int index,int bitmask,int change)
    {
        if(index==s.length()) return 1;

        int ans = 0;
        long key = (long) index<<27 | (long) bitmask<<1 | (long)change ;
        if(hmap.containsKey(key)) return hmap.get(key);

       int pos = s.charAt(index) - 'a';
        int newMask = bitmask | 1<<pos;
        
        if(Integer.bitCount(newMask) > k)
          ans = 1 + recur(index+1,1<<pos,change); 
        else
          ans = recur(index+1,newMask,change);

        if(change==1)
        {
            for(int i=0;i<26;i++)
            {
                int mask = bitmask | 1<<i;
                if(Integer.bitCount(mask) > k)
                 ans = Math.max(ans,1+recur(index+1,1<<i,0));
                else
                 ans = Math.max(ans,recur(index+1,mask,0));
            }
        } 
        hmap.put(key,ans);
        return ans;

    }

}