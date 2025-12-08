class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<int[]> stack = new Stack<>();
        int size = height.length;
        int i;
        int max = 0;
        for(i=0;i<size;i++){
             int ind = i;
            while(!stack.isEmpty() && stack.peek()[1] > height[i]){
                int[] pt = stack.pop();
                ind = pt[0];
                int area = (i - pt[0]) * pt[1];
                max = Math.max(max,area);
            }
            stack.push(new int[]{ind,height[i]});
            
        }
        while(!stack.isEmpty())
        {
           int[] pt = stack.pop();
           int area = (i - pt[0]) * pt[1];
           max = Math.max(max,area);
        }
        return max;
    }
}