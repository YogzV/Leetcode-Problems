class Solution {
    public int maxOperations(String s) {
        int i = 0;
        int len = s.length();
        boolean oneOccur = false;
        int ans = 0;
        int oneCnt = 0;
        while(i < len)
        {
            if(s.charAt(i) == '1'){
                oneCnt++;
                oneOccur = true;
            
            }
            if(oneOccur && (i+1)<len &&  s.charAt(i+1) == '0')
            {
                
                i++;
                while(i<len && s.charAt(i) == '0')
                {
                    i++;
                }
                ans++;
                ans += oneCnt -1;
                

            }else{
                i++;
            }
            
            
        }
        return ans;
    }
}