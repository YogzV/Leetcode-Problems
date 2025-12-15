class Solution {
    public long getDescentPeriods(int[] prices) {
        int i;
        int size = prices.length;
        long ans = 0;
       long count = 1;
        for(i = 1;i<size;i++)
        {
            if(prices[i] + 1 == prices[i-1])
            {
                count++;
            }else{
                ans += ((count * (count-1)) /2);
                count = 1;
            }
            
        }
        ans += ((count * (count-1)) /2);
        return ans + size;
    }
}