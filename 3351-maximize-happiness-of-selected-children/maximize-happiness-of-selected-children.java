class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Queue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : happiness){
            pqueue.offer(num);
        }
        long dec = 0;
        long ans = 0;
        while(k-- > 0)
        {
           ans += Math.max(0,(pqueue.poll() - dec ));
           dec++;
        }
        return ans;
    }
}