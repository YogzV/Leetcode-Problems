class Solution {

    private static int binarySearch(int st,int en,int[] arr,long val)
    {
     int mid;
       while(st < en)
       {
         
        mid = (st+en)/2;
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
       return (en==0)? -1:st;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        double s = (double) success;
        int slen = spells.length;
        int plen = potions.length;
        int i;
        long val;
        Arrays.sort(potions);
        
        int[] ans = new int[slen];
        for(i = 0; i < slen; i++){

             val =(long) Math.ceil(s / spells[i]);
            ans[i] = plen - binarySearch(0,plen,potions,val) - 1;
            
        }
        System.gc();
        return ans;

    }
}