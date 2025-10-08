class Solution {

    private static int binarySearch(int st,int en,int[] arr,long val)
    {
     
       while(st < en)
       {
         
        int mid = (st+en)/2;
        if(arr[mid] < val)
        {
            if(mid==st)
            {
                break;
            }
            st = mid;
        }else{
            en = mid;
        }
       }
       if(en==0)
      {
        return -1;
      }
       return st;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        double s = (double) success;
        int slen = spells.length;
        int plen = potions.length;
        int i,j;
        long val;
        Arrays.sort(potions);
        
        int[] ans = new int[slen];
        for(i = 0; i < slen; i++){

             val =(long) Math.ceil(s / spells[i]);
            int n = binarySearch(0,plen,potions,val);
            ans[i] = plen - n - 1;
            
        }

        return ans;

    }
}