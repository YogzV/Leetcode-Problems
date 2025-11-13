class Solution {
    public int minOperations(int[] nums) {
        int i;
        int size = nums.length;
        int cnt = 0;
        int gcd = 0;
        for(i=0;i<size;i++)
        {
            gcd = findGCD(gcd,nums[i]);
            if(nums[i] == 1){
                cnt++;
            }
        }
        if(cnt > 0)
         return size - cnt;
        if(gcd>1)
         return -1;

        int j; 
        int len = Integer.MAX_VALUE;   
        for(i=0;i<size-1;i++)
        {
            gcd = nums[i];
            for(j=i+1;j<size;j++){
               gcd = findGCD(gcd,nums[j]);
               if(gcd == 1){
                 len = Math.min(len,j-i);
                 break;
               }
            }
        }

        return len + (size-1);
    }

    public static int findGCD(int num1,int num2){
        if(num2 > num1){
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }

        while(num2 != 0){
            int rem = num1 % num2;
            num1 = num2;
            num2 = rem;
        }
        return num1;

    }
}