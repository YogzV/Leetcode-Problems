class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int fp=0;
        int val1,val2;
        int sp = s1.length(); 
        int len2 = s2.length();

        if(sp > len2) return false;

        for(int i=0;i<sp;i++)
        {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        if(matches(freq1,freq2))
            return true;
       
         while(sp < len2){
            
            freq2[s2.charAt(fp++) - 'a']--;
            freq2[s2.charAt(sp++) - 'a']++;  

           if(matches(freq1,freq2))
            return true;
            
         }

         return false;
    }

    public static boolean matches(int[] freq1,int[] freq2){
        for(int i = 0;i<26;i++){
            if(freq1[i] != freq2[i])
             return false;
        }
        return true;
    }
}