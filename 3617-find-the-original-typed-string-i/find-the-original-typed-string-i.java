class Solution {
    public int possibleStringCount(String word) {
        int ans = 1;
        int i;
        for(i = word.length()-1;i>0;i--)
        {
            if(word.charAt(i) == word.charAt(i-1))
             ans++;
        }
        return ans;
    }
}