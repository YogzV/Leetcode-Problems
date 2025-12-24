class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int ans =0 ;
        int total = 0;
        for(int num : apple)
        {
            total += num;
        }
        Arrays.sort(capacity);
        
        for(int i = capacity.length-1;i>=0;i--)
        {
             total -= capacity[i];
             ans++;
             if(total <=0)
             {
                break;
             }
        }
        
        return ans;
    }
}