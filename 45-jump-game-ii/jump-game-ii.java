class Solution {
    public int jump(int[] nums) {
        int left = 0;
        int right = 0;
        int ans = 0;

        while(right < nums.length-1){
            
            int far = 0;
            while(left <= right){
                far = Math.max(far,left + nums[left]);
                left++;
            }

            right = far;
            ans++;
            
        }

        return ans;
    }
}