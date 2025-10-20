class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> hmap = new HashMap<>();
        int i;
        int len = s.length();
        for(i=0;i<len;i++)
        {
            hmap.merge(s.charAt(i),1,Integer::sum);
        }
        for(i=0;i<len;i++)
        {
            if(!hmap.containsKey(t.charAt(i))) return false;
            else{
                hmap.computeIfPresent(t.charAt(i),(k,v)->{
                    if(v==1) return null;
                    else return v-1;
                });
            }
        }
        return true;
    }
}