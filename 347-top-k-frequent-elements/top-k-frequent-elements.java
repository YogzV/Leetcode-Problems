class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i : nums)
        {
            hmap.merge(i,1,Integer::sum);
        }
        PriorityQueue<int[]> pqueue = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for(Integer in : hmap.keySet()){
            pqueue.offer(new int[]{in,hmap.get(in)});
        }
        int[] ans = new int[k];
        while(k-- > 0)
        {
            int[] pt = pqueue.poll();
            ans[k] = pt[0];
        }
        return ans;
        

        
    }
}