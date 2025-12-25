class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans = 0;
        int ind = happiness.length - 1;
        for(int i=0;i<k;i++){
            int val = happiness[ind] - i;
            if(val <= 0) 
              break;
            ans += val;
            ind--;
        }
        return ans;
        
    }
}