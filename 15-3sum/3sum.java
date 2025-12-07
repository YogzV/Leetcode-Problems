class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        int size = nums.length;
        for(int i=0;i<size-2;i++)
        {
            int target = -nums[i];
            int start = i+1;
            int end = size-1;
            while(start < end)
            {
                int val = nums[start] + nums[end];
                if(val > target)
                {
                    end--;
                }else if(val < target)
                {
                    start++;
                }else{
                   set.add(new ArrayList<>(Arrays.asList(nums[i],nums[start],nums[end])));
                   start++;
                   end--;
                }
            }

        }
        return new ArrayList<>(set);
    }
}