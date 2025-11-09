class Solution {
    public int countOperations(int num1, int num2) {
        int temp;
        if(num2 > num1)
        {
            temp = num1;
            num1 = num2;
            num2 = temp;
        }
         int ans = 0;

        while(num2 != 0)
        {
            
            ans += num1/num2;
            temp = num1 % num2;
            num1 = num2;
            num2 = temp;

        }
        return ans;
    }
}