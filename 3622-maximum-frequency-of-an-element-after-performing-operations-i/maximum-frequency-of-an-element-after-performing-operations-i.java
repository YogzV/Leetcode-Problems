class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
         Arrays.sort(nums);
         HashMap<Integer,Integer> hmap = new HashMap<>();
         for(int i:nums)
         {
            hmap.merge(i,1,Integer::sum);
         }
         int len = nums.length;
         int res = 0;
         int lele = nums[len-1];
         
         for(int i = nums[0];i<=lele;i++)
         {
           
            int val = 0;
          
            int lind = lowerBound(nums,i-k,0,len-1);
            int uind = upperBound(nums,i+k,0,len-1);
            if(hmap.containsKey(i))
             val = hmap.get(i);
           
           int ans = uind - lind + 1 - val;
           res = Math.max(res,val + Math.min(ans,numOperations));

         }
         return res;
    }
    private static int lowerBound(int[] nums,int val,int start,int end)
    {
           int ans = 0;
           while(start <= end)
           {
             int mid = (start + end)/2;
             if(nums[mid] >= val)
             {
                ans = mid;
                end = mid-1;
             }else{
            
                start = mid + 1;
             }
           }
           return ans;
    }
    
     private static int upperBound(int[] nums,int val,int start,int end)
    {
          int ans = 0;
          while(start <= end)
          {
            int mid = (start+end)/2;
            if(nums[mid] <= val)
            {
                ans = mid;
               start = mid + 1;
            }else{
                end = mid - 1;
                
            }
          }
          return ans;
    }
}