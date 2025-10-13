class Solution {
    public List<String> removeAnagrams(String[] words) {
        int len = words.length;
        int i=0,j=1;
        List<String> list = new ArrayList<>();
        String str,s;
        while(j<len)
        {
            char[] arr = words[i].toCharArray();
            Arrays.sort(arr);
            str = new String(arr);
           while(j<len)
           {
                char[] ar = words[j].toCharArray();
                Arrays.sort(ar);
                s = new String(ar);
              if(str.equals(s))
                {
                    words[j] = "R";
                }else{
                    i=j;
                    j++;
                    break;
                }
                j++;
            }
        
        }
        for(i=0;i<len;i++)
        {
            if(words[i]!="R")
             list.add(words[i]);
        }
        return list;
    }
}