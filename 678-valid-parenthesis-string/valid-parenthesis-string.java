class Solution {

    Boolean[][] memo;
    public boolean checkValidString(String s) {
        memo = new Boolean[s.length()][101];
        return recur(s,0,0);
    }

    public boolean recur(String s,int ind,int op){
        if(ind >= s.length())
        {
            if(op == 0)
             return true;
            
            return false;
        }
        if(memo[ind][op] != null)
         return memo[ind][op];
        

        boolean res = false;

        if(s.charAt(ind) == '('){
            res = recur(s,ind+1,op+1);
        }else if(s.charAt(ind) == ')' && op > 0){
            res = recur(s,ind+1,op-1);
        }else if(s.charAt(ind) == '*'){
            if(op > 0){
                res = recur(s,ind+1,op-1);
            }
            res = res || recur(s,ind+1,op+1) || recur(s,ind+1,op);
        }
        
        memo[ind][op] = res;
        return res;
    }
}