class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i : piles)
        {
            max = Math.max(max,i);
        }
        
        int minTime = max;
        int start = 1;
        int end = max;
        while(start <= end)
        {
            int mid = (start+end)/2;
            long time = 0;
            for(int i : piles)
            {
               time += (int)Math.ceil(i/(double)mid);
            }

            if(time <= h){
                minTime = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return minTime;
    }
}