class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i : nums)
        {
            hmap.merge(i,1,Integer::sum);
        }
        PriorityQueue<int[]> pqueue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for(Integer in : hmap.keySet()){
            pqueue.offer(new int[]{in,hmap.get(in)});
            if(pqueue.size() > k)
              pqueue.poll();
        }
        int[] ans = new int[k];
        while(k-- > 0)
        {
            
            ans[k] = pqueue.poll()[0];
        }
        return ans;
        

        
    }
}