class Solution {
   
    public int carFleet(int target, int[] position, int[] speed) {
        int i;
        int len = position.length;
        int[][] pair = new int[len][2];
        for(i=0;i<len;i++)
        {
            pair[i][0] = position[i];
            pair[i][1] = speed[i]; 
        }
        Arrays.sort(pair,(a,b) -> b[0] - a[0]);
        Stack<Double> stack = new Stack<>();
        int ans = 0;
        for(i=0;i<len;i++)
        {
           double val = (target - pair[i][0])/(double)pair[i][1];
           
           if(stack.isEmpty() || stack.peek() < val ){
                 stack.push(val);
                 ans+=1;             
           }
        }
        return ans;
    }
    
}