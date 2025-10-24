class Solution {
    public int nextBeautifulNumber(int n) {
        String s = String.valueOf(n+1);
        while(true)
        {
            int i,len = s.length();
            int[] freq = new int[10];
            for(i=0;i<len;i++)
            {
                freq[s.charAt(i)-'0']++;
            }
            
            if(correctNumber(s,freq)) 
                 return Integer.parseInt(s);
            s = String.valueOf(Integer.parseInt(s) + 1);
        }
    }

    public static boolean correctNumber(String s,int[] freq)
    {
       int i,len = s.length();
       for(i=0;i<len;i++)
       {
        int val = s.charAt(i) - '0';
        if(freq[val] != val) return false;
       }
       return true;
    }
}