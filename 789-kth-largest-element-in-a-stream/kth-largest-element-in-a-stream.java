class KthLargest {

    Queue<Integer> pqueue = new PriorityQueue();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k ;
        for(int num : nums)
        {
            pqueue.offer(num);
            if(pqueue.size() > k){
                pqueue.poll();
            }
        }
    }
    
    public int add(int val) {
       
       pqueue.offer(val);
       if(pqueue.size() > k){
        pqueue.poll();
       }

       return pqueue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */