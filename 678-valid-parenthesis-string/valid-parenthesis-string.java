class Solution {

    Boolean[][][] memo;
    public boolean checkValidString(String s) {
        memo = new Boolean[s.length()][101][101];
        return recur(s,0,0,0);
    }

    public boolean recur(String s,int ind,int op,int cp){
        if(ind >= s.length())
        {
            if(op == cp)
             return true;
            
            return false;
        }
        if(memo[ind][op][cp] != null)
         return memo[ind][op][cp];
        

        boolean res = false;

        if(s.charAt(ind) == '('){
            res = recur(s,ind+1,op+1,cp);
        }else if(s.charAt(ind) == ')' && op > cp){
            res = recur(s,ind+1,op,cp+1);
        }else if(s.charAt(ind) == '*'){
            if(op > cp){
                res = recur(s,ind+1,op,cp+1);
            }
            res = res || recur(s,ind+1,op+1,cp) || recur(s,ind+1,op,cp);
        }
        
        memo[ind][op][cp] = res;
        return res;
    }
}