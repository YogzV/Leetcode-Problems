class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int fp = 0;
        int sp = 0;
        int maxLen = 0;
        int maxFreq = 0;
        int len = s.length();
        int changes;
        while(sp < len)
        {
            int val = s.charAt(sp) - 65;
            freq[val]++;
            maxFreq = Math.max(maxFreq,freq[val]);
            changes = sp-fp+1 - maxFreq;
            if(changes <= k){
              maxLen = Math.max(maxLen, sp-fp+1);
            }
            else{
                 freq[s.charAt(fp) - 65]--;
                 fp++;
                
            }
            sp++;

        }
        return maxLen;
    }
}