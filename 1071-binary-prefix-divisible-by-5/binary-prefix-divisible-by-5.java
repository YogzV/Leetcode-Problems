class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        
        List<Boolean> list = new ArrayList<>();
        int i;
        int size = nums.length;
        long val = 0;

        if(nums[0] == 1)
         val = 1;
        
        for(i=0;i<size;i++)
        {
            if(val%5==0)
            {
                list.add(true);
            }else{
                list.add(false);
            }

             val*=2;
            if(i<size-1)
            {
                if(nums[i+1] == 1)
                {
                    val+=1;
                }
            }
            val = val%10;
        }
        
        

        
        
        return list;
    }
}