class Solution {
    public int minimumDeletions(String s) {
        int len = s.length();
        int ans = len;
        int aCnt = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'a') 
              aCnt+=1;
        }
        int bCnt = 0;

        for(char ch : s.toCharArray()){
            if(ch == 'a')
             aCnt -= 1;
            
            ans = Math.min(ans,bCnt + aCnt);
            if(ch == 'b')
              bCnt += 1;

        }
        return ans;
    }
}