class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens){
            char ch = str.charAt(0);
            if(str.length() == 1 && !Character.isDigit(ch))
            {
                int val2 = stack.pop();
                int val1 = stack.pop();
                int res = 0;
                if(ch == '+')
                {
                    res = val1 + val2;
                }else if(ch == '-')
                {
                    res = val1- val2;
                }else if(ch == '*')
                {
                    res = val1 * val2;
                }else {
                    res = val1 / val2;
                }
                stack.push(res);
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}