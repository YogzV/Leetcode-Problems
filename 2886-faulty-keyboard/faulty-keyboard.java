class Solution {
    public String finalString(String s) {
        StringBuilder str = new StringBuilder();
       
        
        int i;
        int len = s.length();
        for(i=0;i<len;i++)
        {
            if(s.charAt(i) == 'i')
            {
                int start = 0;
                int end = str.length() -1;
                while(start < end)
                {
                    char temp = str.charAt(start);
                    str.setCharAt(start++,str.charAt(end));
                    str.setCharAt(end--,temp);
                }
            }else{
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}