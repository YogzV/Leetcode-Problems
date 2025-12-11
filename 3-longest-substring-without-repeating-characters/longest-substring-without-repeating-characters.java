class Solution {
    public int lengthOfLongestSubstring(String s) {
        int fp = 0;
        int sp = 0;
        int len = s.length();
        int maxLen = 0;
        HashMap<Character,Integer> hmap = new HashMap<>();
        while(sp < len)
        {
           if(hmap.containsKey(s.charAt(sp))){
            if(hmap.get(s.charAt(sp)) >= fp){
              fp = hmap.get(s.charAt(sp)) + 1;
            }
             
           }

           hmap.put(s.charAt(sp),sp);
           maxLen = Math.max(sp - fp +1 ,maxLen);
           sp++;
        }

        return maxLen;
    }
}