class Solution {
    public int countSubstrings(String s) {

        int ans = 0;
        

        for(int i=s.length()-1;i>=0;i--)
          ans += countPalindrome(s,i,i) + countPalindrome(s,i-1,i);
        
        
        return ans;
    }

    public int countPalindrome(String s,int left,int right){
        int ans = 0;
        int len = s.length();

        while(left>=0 && right<len && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                ans++;
            }
        return ans;
    }
}