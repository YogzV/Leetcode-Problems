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
       dp[0] = hmap.get(list.get(0)) * list.get(0);
       for(i=1;i<len;i++)
       {
          long take = list.get(i) * hmap.get(list.get(i));
          int prev = bsearch(i-1,list,list.get(i)-2,dp);
          if(prev>=0)
          {
            take += dp[prev];
          }
          dp[i] = Math.max(take,dp[i-1]);
          System.out.println(dp[i]);


       }
       return dp[len-1];
    }

    private static int bsearch(int index,List<Integer> list,int maxVal,long[] dp)
    {
        int st = 0,en = index;
        int ans = -1;
        while(st <= en)
        {
            int mid = (st+en)/2;
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