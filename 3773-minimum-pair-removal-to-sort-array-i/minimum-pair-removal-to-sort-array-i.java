class Solution {
    public int minimumPairRemoval(int[] nums) {
        int size = nums.length;
        int i;
        int ans = 0;
        for(i=0;i<size-1;i++){
            boolean fnd = true;

            for(int j=0;j<size;j++){
                int k = j+1;
                while(k<size && nums[k] == Integer.MIN_VALUE){
                    k++;
                }
                 if(k <size && nums[j] > nums[k]){
                    fnd = false;
                    break;
                 }
            }
            if(fnd){
                break;
            }
             

            int ind1 = -1;
            int ind2 = -1;
            int sum = Integer.MAX_VALUE;
            for(int j=0;j<size-1;j++){
                int k = j+1;
                while(k<size && nums[k]==Integer.MIN_VALUE){
                    
                    k++;
                }
                int currSum = nums[j] + ((k<size)?nums[k] : 0);
                if(k<size && sum > currSum){
                    
                    ind1 = j;
                    ind2 = k;
                    sum = currSum;
                    
                }
                j=k-1;
            }

            nums[ind1] = sum;
            nums[ind2] = Integer.MIN_VALUE;

           
            ans++;
        }

        return ans;
    }
}