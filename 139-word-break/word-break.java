class Solution {
    Map<Integer,Boolean> hmap = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
       hmap.put(s.length(),true);
        return recur(s,wordDict,0);
    }

    public boolean recur(String s,List<String> wordDict,int ind){
        if(hmap.containsKey(ind))
         return hmap.get(ind);

        for(String str : wordDict){
            if(ind + str.length() <= s.length() && s.substring(ind,ind+str.length()).equals(str)){
                if(recur(s,wordDict,ind + str.length())){
                  hmap.put(ind,true);
                  return true;
                }
            }
        }
         hmap.put(ind,false);
        return false;
    }
}