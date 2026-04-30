class Solution {
    public int minimumDifference(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
                Arrays.sort(nums);

        int i=0,j = k-1;
        while(j<nums.length){
            ans = Math.min(ans,nums[j]-nums[i]);
            i++;
            j++;
        }
        return ans;
    }
}