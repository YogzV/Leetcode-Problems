class Solution {
   
    public int carFleet(int target, int[] position, int[] speed) {
        int i;
        int len = position.length;
        int[][] pair = new int[len][2];
        for(i=0;i<len;i++)
        {
            pair[i][0] = target - position[i];
            pair[i][1] = speed[i]; 
        }
        Arrays.sort(pair,(a,b) ->a[0] - b[0]);
        Stack<Double> stack = new Stack<>();
        
        for(i=0;i<len;i++)
        {
           double val = pair[i][0]/(double)pair[i][1];
           
           if(stack.isEmpty() || stack.peek() < val ){
                 stack.push(val);
                              
           }
        }
        return stack.size();
    }
    
}