class Solution {
    public int countTriples(int n) {
        int res = 0;
        int max = n*n;
        for(int i=3;i<=n-2;i++)
        {
            
            for(int j=i+1;j<n;j++)
            {
                
                int val =(i*i) + (j*j);
              
                if(val > max) break;
                System.out.println(val);
                int c = (int)Math.sqrt(val);
                int check = c * c;
                
                if(check == val){
                    res+=2;
                }
            }
        }
        return res;
    }
}