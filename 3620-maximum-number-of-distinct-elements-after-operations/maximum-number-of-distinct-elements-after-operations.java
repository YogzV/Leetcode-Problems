class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        int i;
        int step = nums[0] - k;
        int cnt = 0;
        for(i = 0 ; i < len ; i++)
        {
           int low = nums[i] - k;
           int high = nums[i] + k;
           if(step < low)
           {
            step = low;
           }
           if(step <= high)
           {
            cnt++;
            step++;
           }
        }
        return cnt;
    }
}