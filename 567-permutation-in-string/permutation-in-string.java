class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int i;
        
        int len = s1.length();
        int len2 = s2.length();
        if(len > len2) return false;
        for(i=0;i<len;i++)
        {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }
        int match = 0;
        for(i=0;i<26;i++)
        {
          if(freq1[i] == freq2[i]) 
            match++;
        }
       
         int fp=0;
         int sp = len;
         
         
         while(sp < len2){
            if(match == 26) return true;
            int val1 = s2.charAt(fp) - 'a';
            int val2 = s2.charAt(sp) - 'a';
            freq2[val1]--;
            fp++;
            freq2[val2]++;  

           if(matches(freq1,freq2))
            return true;

            sp++;
         }
         return matches(freq1,freq2);

    }

    public static boolean matches(int[] freq1,int[] freq2){
        for(int i = 0;i<26;i++){
            if(freq1[i] != freq2[i])
             return false;
        }
        return true;
    }
}