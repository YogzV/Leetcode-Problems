class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
         for(int i : nums)
         {
            while(!stack.isEmpty() && stack.peek()>i){
                stack.pop();
                
            }             
 
            if(i!=0 && (stack.isEmpty() || stack.peek() < i)){
                ans++;
                stack.push(i);
            }
         }
 

        return ans;
    }
}