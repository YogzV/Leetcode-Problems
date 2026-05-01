class Solution {
    public int maxRotateFunction(int[] nums) {
        int size = nums.length;
        int[] ans = new int[size];

        int i,j;
        int sum = 0;
       
        for(i=0;i<size;i++){
            ans[0] += (nums[i] * i);
            sum += nums[i]; 
        }
        int max = ans[0];
        

        for(j=1;j<size;j++){
            ans[j] = ((ans[j-1] + sum - nums[size-j]) - (size-1) * nums[size-j]); 
            max = Math.max(ans[j],max);
        }

        

        return max;
    }
}