public class Solution {
    
        public String longestPalindrome(String s) {
      int start = 0;      // starting index of longest palindrome
        int maxLen = 1;    // length of longest palindrome

        for (int i = 0; i < s.length(); i++) {

            // check odd length palindrome (center at i)
            int oddLen = stretch(s, i, i);

            // check even length palindrome (center between i and i+1)
            int evenLen = stretch(s, i, i + 1);

            int bestLen = Math.max(oddLen, evenLen);

            if (bestLen > maxLen) {
                maxLen = bestLen;
                start = i - (bestLen - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    // this method stretches from the center and returns palindrome length
    private int stretch(String s, int left, int right) {

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        // we went one step extra, so fix the length
        return right - left - 1;  
    }

}