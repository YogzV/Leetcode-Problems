class Solution {
    public int maxRotateFunction(int[] nums) {
        int size = nums.length;
        int prev = 0;
        int curr = 0;

        int i,j;
        int sum = 0;
       
        for(i=0;i<size;i++){
            prev += (nums[i] * i);
            sum += nums[i]; 
        }
        int max = prev;
        

        for(j=1;j<size;j++){
            int val = (size-1) * nums[size-j];
            curr = prev + sum - nums[size-j] - val; 
            max = Math.max(curr,max);
            prev = curr;
        }

        

        return max;
    }
}