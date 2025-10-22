class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hmap = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        int i;
        int len = strs.length;
        for(i=0;i<len;i++)
        {
            char[] str = strs[i].toCharArray();;
            Arrays.sort(str);
            String s = new String(str);
            if(hmap.containsKey(s))
            {
                List<String> l = hmap.get(s);
                l.add(strs[i]);
                hmap.put(s,l);
              
            }else{
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                hmap.put(s,l);
            }

        }
    for(List<String> lis : hmap.values())
    {
        ans.add(lis);
    }

     return ans;
    }
}