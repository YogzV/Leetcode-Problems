class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int ans =0 ;
        int total = 0;
        for(int num : apple)
        {
            total += num;
        }
        Arrays.sort(capacity);
        int have = 0;
        for(int i = capacity.length-1;i>=0;i--)
        {
             have += capacity[i];
             ans++;
             if(have >= total)
             {
                break;
             }
        }
        
        return ans;
    }
}