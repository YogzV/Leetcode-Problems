class Solution {
    public long maximumTotalDamage(int[] power) {
        HashMap<Integer,Long> hmap = new HashMap<>();
       for(int i : power)
       {
        hmap.merge(i,1L,Long::sum);
       } 
       List<Integer> list = new ArrayList<>(hmap.keySet());
       Collections.sort(list);
       int len = list.size();
       int i;
       long[] dp = new long[len];
       long take;
       int prev;
       dp[0] = hmap.get(list.get(0)) * list.get(0);
       for(i=1;i<len;i++)
       {
          take = list.get(i) * hmap.get(list.get(i));
          prev = bsearch(i-1,list,list.get(i)-2,dp);
          if(prev>=0)
          {
            take += dp[prev];
          }
          dp[i] = Math.max(take,dp[i-1]);
          


       }
       return dp[len-1];
    }

    public static int bsearch(int index,List<Integer> list,int maxVal,long[] dp)
    {
        int st = 0,en = index;
        int ans = -1;
        int mid;
        while(st <= en)
        {
            mid = (st+en)/2;
            if(list.get(mid) < maxVal)
            {
                st = mid+1;
                ans = mid;

            }else{
                en = mid-1;
            }
        }
        return ans;

    }
}