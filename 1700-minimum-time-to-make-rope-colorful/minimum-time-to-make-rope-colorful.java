class Solution {
    public int minCost(String colors, int[] neededTime) {
        int i;
        int len = colors.length();
        int prev = neededTime[0];
        int ans = 0;
        for(i = 1;i<len;i++)
        {
            int sum = prev;
            int max = sum;
            boolean sameColor = false;
            while(i<len && colors.charAt(i)==colors.charAt(i-1))
            {
                
                sum+=neededTime[i];
                max = Math.max(neededTime[i],max); 
                sameColor = true;
                i++;
                
            }
            
            if(sameColor)
            {
                ans += (sum-max);
                
            }
            if(i<len)
             prev = neededTime[i];

        }
        return ans;
    }
}