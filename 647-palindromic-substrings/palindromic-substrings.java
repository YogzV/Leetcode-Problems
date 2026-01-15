class Solution {
    public int countSubstrings(String s) {

        int ans = 0;
        int len = s.length();

        for(int i=0;i<len;i++){

            int left = i;
            int right = i;

            while(left>=0 && right<len && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                ans++;
            }

           

            left = i;
            right = i+1;

            while(left>=0 && right<len && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                ans++;
            }

        }
        
        return ans;
    }
}