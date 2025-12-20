class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] freq = new int[128];

        // Count frequency of t
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0, right = 0;
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char r = s.charAt(right);

            // If this char is needed, decrease required
            if (freq[r] > 0) {
                required--;
            }
            freq[r]--;
            right++;

            // Valid window found
            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char l = s.charAt(left);
                freq[l]++;

                // If char becomes needed again
                if (freq[l] > 0) {
                    required++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
