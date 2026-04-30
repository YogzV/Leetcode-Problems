class Solution {
    public int minimumPairRemoval(int[] nums) {
        int size = nums.length;
        int i,j,k;
        int ans = 0;
        while(true){
            boolean fnd = true;

            for(j=0;j<size;j++){
                k = j+1;
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
            for(j=0;j<size-1;){
                k = j+1;
                while(k<size && nums[k]==Integer.MIN_VALUE){
                    
                    k++;
                }
                
                if(k<size){
                    int currSum = nums[j] + nums[k];
                    if(sum > currSum){
                        ind1 = j;
                        ind2 = k;
                        sum = currSum;
                    }
                }
                j=k;
            }

            nums[ind1] = sum;
            nums[ind2] = Integer.MIN_VALUE;

           
            ans++;
        }

        return ans;
    }
}