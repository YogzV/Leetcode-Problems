class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length -1;
        while(start <= end)
        {
            int val = numbers[start] + numbers[end];
            if(val > target)
            {
                end--;
            }else if(val < target)
            {
                start++;
            }else{
                break;
            }
        }
        return new int[]{start+1,end+1};
    }
}