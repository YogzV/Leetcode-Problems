class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        int max_prev = 0;
        PriorityQueue<int[]> pqueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
       for(int i=0;i<events.length;i++)
       {
          int start = events[i][0];
          int end = events[i][1];
          int val = events[i][2];
          while(!pqueue.isEmpty() && pqueue.peek()[0] < start){ 
            max_prev = Math.max(max_prev,pqueue.poll()[1]);
          }
        
          pqueue.offer(new int[]{end,val});
          ans = Math.max(ans,max_prev+val);
       }

        return ans;
    }
}