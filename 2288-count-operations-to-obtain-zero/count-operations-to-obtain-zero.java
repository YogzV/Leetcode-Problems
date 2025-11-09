class Solution {
    public int countOperations(int num1, int num2) {
        if(num2 > num1)
        {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
         int ans = 0;

        while(num2 != 0)
        {
            int quo = num1 / num2;
            ans += quo;
            int rem = num1 % num2;
            num1 = num2;
            num2 = rem;

        }
        return ans;
    }
}