class Solution {
    public int trap(int[] height) {
        int size = height.length;
        
     
        int[] rightwall = new int[size];
        rightwall[size-1] = height[size-1];
        
        int max = height[size-1];
        for(int i = size-2;i>=0;i--)
        {
            rightwall[i] = max;
            max = Math.max(max,height[i]);
        }
        int water = 0;
        max = height[0];
        for(int i =1;i<size-1;i++)
        {
 
            if(max>height[i] && rightwall[i] > height[i])
            {
                water+=Math.min(max,rightwall[i]) - height[i];
                
            }
            max = Math.max(max,height[i]);
        }
        return water;
    }
}