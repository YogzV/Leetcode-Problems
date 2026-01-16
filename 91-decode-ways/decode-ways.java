class Solution {
   
    public int numDecodings(String s) {
        
        int n = s.length();
        
        int dp2 = 1;
        int dp1 = 1;
        int curr = 0;
        for(int i = n-1 ;i>=0;i--){
            if(s.charAt(i) == '0')
              curr = 0;
            else{
                curr = dp1;
                if(i < n-1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) < '7'))
                {
                    curr += dp2;
                }
            } 
            dp2 = dp1;
            dp1 = curr;
            
        }
        return dp1;
    }

}