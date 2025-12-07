class Solution {
    public int trap(int[] height) {

        int size = height.length;
       
        int start = 0;
        int end = size-1;
         int leftMax = height[start];
        int rightMax = height[end];
        int water = 0;
        while(start < end)
        {
            if(leftMax <= rightMax)
            {
                start++;
               
                leftMax = Math.max(leftMax,height[start]);
                 water += leftMax - height[start];
                
                
            }else{
                end--;
               
                rightMax = Math.max(rightMax,height[end]);
                 water += rightMax - height[end];
                
            }
            System.out.println(water);
        }
        return water;
        
    }
}