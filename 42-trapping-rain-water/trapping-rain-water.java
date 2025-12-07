class Solution {
    public int trap(int[] height) {
        int size = height.length;
        int[] leftwall = new int[size];
        leftwall[0] = height[0];
        int[] rightwall = new int[size];
        rightwall[size-1] = height[size-1];
        int max = height[0];
        for(int i =1;i<size;i++)
        {
           leftwall[i] = max;
           max = Math.max(max,height[i]);
        }

        max = height[size-1];
        for(int i = size-2;i>=0;i--)
        {
            rightwall[i] = max;
            max = Math.max(max,height[i]);
        }
        int water = 0;
        for(int i =1;i<size-1;i++)
        {

            if(leftwall[i]>height[i] && rightwall[i] > height[i])
            {
                water+=Math.min(leftwall[i],rightwall[i]) - height[i];
                
            }
        }
        return water;
    }
}