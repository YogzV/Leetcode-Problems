class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder str = new StringBuilder(s);
        while(str.length()>2)
        {
            int i;
            int len = str.length();
            StringBuilder temp = new StringBuilder();
            for(i=0;i<len-1;i++)
            {
               int val1 = str.charAt(i)-'0';
               int val2 = str.charAt(i+1)-'0';
               int res = (val1+val2) % 10;
               temp.append((char)(res+'0'));

            } 
            str = new StringBuilder(temp.toString());
        }
        if(str.charAt(0) == str.charAt(1)) return true;
        return false;
    }
}