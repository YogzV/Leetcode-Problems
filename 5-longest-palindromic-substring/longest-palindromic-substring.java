class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 0;
        int len = s.length();

        for(int i=0;i<len;i++){

            int left = i;
            int right = i;

            while(left>=0 && right<len && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }

            left++;
            right--;
            if((right-left + 1) > maxLen){
                maxLen = right-left + 1;
                start = left;
            }

            left = i;
            right = i+1;

            while(left>=0 && right<len && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }

            left++;
            right--;
            if((right-left + 1) > maxLen){
                
                maxLen = right-left + 1;
                start = left;
                
            }
        }
        
        return s.substring(start,start+maxLen);

    }
}