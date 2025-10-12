class Solution {
    public int smallestNumber(int n) {
        int i=0;
        int val;
        while(true)
        {
            val = (int)Math.pow(2,i);
            if(val > n)
            {
                break;
            }
            i++;
        }
        
        i--;
        
        
        
        if((int)Math.pow(2,i) -1  == n) return n;
        return ((int)Math.pow(2,i+1))-1;
    }
}