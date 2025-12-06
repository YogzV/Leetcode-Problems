class Solution {
    public boolean isAnagram(String s, String t) {
        
        int[] freq = new int[26];
        for(char ch : s.toCharArray())
        {
            freq[ch-97]++;
        }
        for(char ch : t.toCharArray())
        {
            int val = ch-97;
            if(freq[val] == 0)
             return false;
            
            freq[val]--;
        }
        for(int i=0;i<26;i++)
        {
            if(freq[i] !=0)
             return false;
        }
        return true;
    }
}