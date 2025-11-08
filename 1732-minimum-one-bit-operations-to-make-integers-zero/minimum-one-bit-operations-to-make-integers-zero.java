class Solution {
    public int minimumOneBitOperations(int n) {
        if(n ==0) return 0;
        int  k = 0;
        int val = (int)Math.pow(2,k); 
        while(val<= n)
        {
            
            k++;
            val = (int)Math.pow(2,k);
        }
        k--;
        val = (int)Math.pow(2,k);
        int ans = (int)Math.pow(2,k+1) -1; 
        return  ans - minimumOneBitOperations(val ^ n);
    }
}