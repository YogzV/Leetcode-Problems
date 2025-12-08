class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray())
        {
           
            if(ch == '(')
             stack.push(')');
            else if(ch == '[')
             stack.push(']');
            else if(ch == '{')
             stack.push('}');
            else if(ch == ')'){
             if(stack.isEmpty() || stack.pop() != ')')
              return false;
            }
            else if(ch == ']'){
             if(stack.isEmpty() || stack.pop() != ']')
              return false;
            }
            else {
             if(stack.isEmpty() || stack.pop() != '}')
              return false;
            }
        }
       
        if(!stack.isEmpty())
         return false;

        return true;
    }
}