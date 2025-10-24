class Solution {
    public int nextBeautifulNumber(int n) {
        String s = String.valueOf(n+1);
        while(true)
        {
            
            
            if(correctNumber(s)) 
                 return Integer.parseInt(s);
            s = String.valueOf(Integer.parseInt(s) + 1);
        }
    }

    public static boolean correctNumber(String s)
    {

            int i,len = s.length();
            int val;
            int[] freq = new int[10];
            for(i=0;i<len;i++)
            {
                val = s.charAt(i) - '0';
                freq[val]++;
                if(freq[val] > val)
                 return false;

            }
    
       for(i=0;i<len;i++)
       {
        val = s.charAt(i) - '0';
        if(freq[val] != val) return false;
       }
       return true;
    }
}