class Solution {
    public int minCost(String colors, int[] neededTime) {
        int i,max,sum;
        int len = colors.length();
        boolean sameColor;
        int ans = 0;
        for(i = 1;i<len;i++)
        {
            sum = neededTime[i-1];
            max = sum;
            sameColor = false;
            while(i<len && colors.charAt(i)==colors.charAt(i-1))
            {
                
                sum+=neededTime[i];
                max = Math.max(neededTime[i++],max); 
                sameColor = true;
            
                
            }
            
            if(sameColor) ans += (sum-max);
        }
        return ans;
    }
}