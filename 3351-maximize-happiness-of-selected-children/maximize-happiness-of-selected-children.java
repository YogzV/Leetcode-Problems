class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans = 0;
        int ind = happiness.length - 1;
        for(int i=0;i<k;i++){
            ans += Math.max(0,happiness[ind] - i);
            ind--;
        }
        return ans;
        
    }
}