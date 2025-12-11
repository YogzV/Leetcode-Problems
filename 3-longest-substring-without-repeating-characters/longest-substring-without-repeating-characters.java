class Solution {
    public int lengthOfLongestSubstring(String s) {
        int fp = 0;
        int sp = 0;
        int len = s.length();
        int maxLen = 0;
        HashMap<Character,Integer> hmap = new HashMap<>();
        while(sp < len)
        {
           while(fp < sp && hmap.containsKey(s.charAt(sp))){
             
             hmap.computeIfPresent(s.charAt(fp),(k,v) -> null);
             
             fp++;
           }

           hmap.put(s.charAt(sp),1);
           maxLen = Math.max(sp - fp +1 ,maxLen);
           sp++;
        }

        return maxLen;
    }
}