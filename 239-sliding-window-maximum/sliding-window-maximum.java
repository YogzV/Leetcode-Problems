class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pqueue = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int fp = 0;
        int sp = k-1;
        int[] ans = new int[nums.length - k +1];
        while(fp < sp)
        {
            pqueue.offer(new int[]{nums[fp],fp});
            fp++;
        }
        fp = 0;
        while(sp < nums.length)
        {
            pqueue.offer(new int[]{nums[sp],sp});
            sp++;
           
            while(!pqueue.isEmpty()){
                int[] pt = pqueue.peek();
                
                if(pt[1] >= fp){
                  break;
                }
                pqueue.poll();
            }
            ans[fp] = pqueue.peek()[0]; 
            fp++;
        }
        return ans;
    }
}