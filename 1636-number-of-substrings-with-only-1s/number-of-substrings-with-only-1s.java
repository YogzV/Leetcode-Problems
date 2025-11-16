class Solution {
    public int numSub(String s) {
        int len = s.length();
        int i;
        int onesLen = 0;
        long ans = 0;
        long mod = 1000000007L;
        for(i=0;i<len;i++)
        {
            if(s.charAt(i) == '1')
            {
                onesLen++;
                ans += onesLen;

            }else{
                onesLen = 0;
            }
        }
        return (int)(ans%mod);
    }
}