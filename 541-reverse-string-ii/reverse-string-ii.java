class Solution {
    public String reverseStr(String s, int k) {
        int i;
        int len = s.length();
        StringBuilder str = new StringBuilder(s);
        for(i=0;i<len;i+=2*k)
        {
            int start = i;
            int end = i+k-1;
            if(len - i < k)
            {
                end = len-1;
            }
            while(start < end)
            {
                char temp = str.charAt(start);
                str.setCharAt(start++,str.charAt(end));
                str.setCharAt(end--,temp);
            }
        }
        return str.toString();
    }
}