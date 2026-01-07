class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pqueue = new PriorityQueue<>();
        for(int num : nums){
           pqueue.offer(num);
           if(pqueue.size() > k)
            pqueue.poll();
        }
        return pqueue.peek();
    }
}