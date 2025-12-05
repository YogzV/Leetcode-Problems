class Solution {
    public int countPartitions(int[] nums) {
        int ans = 0;
        int i;
        int size = nums.length;
        int rightsum = 0;
        int leftsum = 0;
        int diff;
        for(i=0;i<size;i++)
        {
          rightsum+=nums[i];
        }
        for(i=0;i<size-1;i++)
        {
            leftsum += nums[i];
            rightsum -= nums[i];
            diff = Math.abs(rightsum - leftsum);
            if((diff & 1) == 0){
                ans++;
            }
        }
        

        return ans;
    }
}