class Solution {
    HashMap<Integer,Integer> dp;
    public int numDecodings(String s) {
        dp = new HashMap<>();
        dp.put(s.length(),1);
        return recur(s,0);
        
    }

    public int recur(String s,int ind){
        if(dp.containsKey(ind))
         return dp.get(ind);

        if(s.charAt(ind) == '0')
         return 0;

        int ans = recur(s,ind+1);

        if(ind < s.length()-1 && (s.charAt(ind) == '1' || s.charAt(ind) == '2' && s.charAt(ind+1) < '7'))   {
            ans += recur(s,ind+2);
        }

        dp.put(ind,ans);
        return ans;
    }
}