class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int size = nums.length;
        for(int i=0;i<size-2;i++)
        {
            if(nums[i] > 0) break;
            if(i> 0 && nums[i] == nums[i-1]) continue;

            int target = -nums[i];
            int start = i+1;
            int end = size-1;
            while(start < end)
            {
                // -4 -1 -1 0 1 2
                int val = nums[start] + nums[end];
                if(val > target)
                {
                    end--;
                }else if(val < target)
                {
                    start++;
                }else{
                   list.add(Arrays.asList(nums[i],nums[start],nums[end]));
                   
                   start++;
                   end--;
                   while(start < end && nums[start] == nums[start-1]){
                    start++;
                    
                   } 
                }
            }

        }
        return list;
    }
}