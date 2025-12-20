class Solution{
    public String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if(len2 > len1) return "";

        Map<Character,Integer> tmap = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        for(char ch : t.toCharArray())
        {
            tmap.merge(ch,1,Integer::sum);
        }
        int fp = 0;
        int sp = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int have = 0;
        while(sp < len1)
        {
             char rch = s.charAt(sp);
             window.merge(rch,1,Integer::sum);
             if(tmap.containsKey(rch) && tmap.get(rch) >= window.get(rch))
               have++;

             while(have == len2)
             {
                if(sp-fp+1 < min)
                {
                    min = sp-fp+1;
                    start = fp;
                    end = sp;
                }
                
                char lch = s.charAt(fp);
                
                window.merge(lch,-1,Integer::sum);
                
                if(tmap.containsKey(lch) && tmap.get(lch) > window.get(lch))
                {
                    have--;
                }
                fp++;
             } 
             sp++;
        }

        if(min > len1)
         return "";
        
        return s.substring(start,start+min);
    }
}