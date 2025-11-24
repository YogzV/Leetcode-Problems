class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        
        List<Boolean> list = new ArrayList<>();
        int i;
        int size = nums.length;
        int val = nums[0];

        for(i=0;i<size-1;i++)
        {
           list.add(val%5 == 0? true:false);
           val = ((val*2) + nums[i+1])%10;
        }
        list.add(val%5 == 0? true:false);
        return list;
    }
}