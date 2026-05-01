class Solution {
    public int maxRotateFunction(int[] nums) {
        int size = nums.length;
        int prev = 0;
        int curr = 0;

        int i;
        int sum = 0;
       
        for(i=0;i<size;i++){
            prev += (nums[i] * i);
            sum += nums[i]; 
        }
        int max = prev;
        

        for(i=1;i<size;i++){
            int val = (size) * nums[size-i];
            curr = prev + sum - val; 
            max = Math.max(curr,max);
            prev = curr;
        }

        return max;
    }
}