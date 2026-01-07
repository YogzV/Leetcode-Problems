class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : stones){
            pqueue.offer(num);
        }
        int x,y;
        while(pqueue.size() > 1){
             x = pqueue.poll();
             y = pqueue.poll();
           
            if(x!=y){
                pqueue.offer(Math.abs(x-y));
            }
        }
        return pqueue.isEmpty()? 0 : pqueue.peek();
    }
}