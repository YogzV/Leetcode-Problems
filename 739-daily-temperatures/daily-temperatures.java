class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int size = temperatures.length;
        int[] ans = new int[size];
        stack.push(0);
        int cnt = 0;
        for(int i = 1;i<size;i++)
        {
           while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i])
           {
              int val = stack.pop();
              ans[val] = i-val; 
           }
           stack.push(i);
   
        }

        while(!stack.isEmpty())
        {
            ans[stack.pop()] = 0;
        }
        return ans;
    }
}