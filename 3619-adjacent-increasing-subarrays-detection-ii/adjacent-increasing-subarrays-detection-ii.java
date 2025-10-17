class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int len = nums.size();
        int cnt = 1;
        int prev = 0;
        int ans = 1;
        for(int i = 1 ;i<len;i++)
        {
            if(nums.get(i) > nums.get(i-1)) 
            {
                cnt++;
            }else{
                prev = cnt;
                cnt = 1;
            }

            int min = Math.min(prev,cnt);
            int max = Math.max(cnt/2,min);
            
            ans = Math.max(ans,max);
        }


        return ans;
    }
}