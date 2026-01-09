class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        helper(n,n,str);
        return res;
    }

    public void helper(int op,int cl,StringBuilder str){
        if(op==0 && cl==0){
            res.add(str.toString());
            return;
        }

        if(op == cl){
            str.append('(');
            helper(op-1,cl,str);
            str.deleteCharAt(str.length() -1);

        }else {
            if(op !=0){
                str.append('(');
                helper(op-1,cl,str);
                str.deleteCharAt(str.length() -1);
            }
            str.append(')');
            helper(op,cl-1,str);
            str.deleteCharAt(str.length()-1);
        }
        return;
    }
}