class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int start=0;
        int end = len-1;
        int maxWater = 0;
        while(start <= end)
        {
            int min = Math.min(height[start],height[end]);
            maxWater = Math.max(maxWater,(end-start)*min);
          
           if(height[start] < height[end])
           {
            start++;
           }else{
            end--;
           }
        }
        return maxWater;

    }
}