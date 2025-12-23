class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a,b) -> {
            if(a[0] > b[0]) return 1;
            return -1;
        });
        int ans = 0;
        int max_prev = 0;
        PriorityQueue<int[]> pqueue = new PriorityQueue<>((a,b)->{
            if(a[0] > b[0]) return 1;
            return -1;
        });
       for(int i=0;i<events.length;i++)
       {
          while(!pqueue.isEmpty() && pqueue.peek()[0] < events[i][0]){
            
            max_prev = Math.max(max_prev,pqueue.poll()[1]);
          }
          
          
          pqueue.offer(new int[]{events[i][1],events[i][2]});
          ans = Math.max(ans,max_prev+events[i][2]);
       }

        return ans;
    }
}