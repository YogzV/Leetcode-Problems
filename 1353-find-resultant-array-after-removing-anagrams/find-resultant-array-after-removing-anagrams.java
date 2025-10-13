class Solution {
    public List<String> removeAnagrams(String[] words) {
        int len = words.length;
        int i=0,j=1;
        List<String> list = new ArrayList<>();
        
        while(j<len)
        {
            char[] arr = words[i].toCharArray();
            Arrays.sort(arr);
           String str = new String(arr);
            char[] ar = words[j].toCharArray();
            Arrays.sort(ar);
            String s = new String(ar);
          if(str.equals(s))
          {
            words[j] = "R";
          }else{
            i=j;
          }
          j++;
        }
        for(i=0;i<len;i++)
        {
            if(words[i]!="R")
             list.add(words[i]);
        }
        return list;
    }
}