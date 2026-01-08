class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
      for(char ch : tasks)
       freq[ch-'A']++;

      Queue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
      for(int cnt : freq){
        if(cnt > 0){
           pqueue.offer(cnt);
        }
      }
      Queue<int[]> queue = new LinkedList<>();
      int time = 0;
      while(!pqueue.isEmpty() || !queue.isEmpty()){
             time++;
             if(pqueue.isEmpty()){
                time = queue.peek()[1];
             }else{
                int cnt = pqueue.poll() - 1;
                if(cnt > 0)
                  queue.offer(new int[]{cnt,time+n});
             }

             if(!queue.isEmpty() && queue.peek()[1] == time)
             {
                pqueue.offer(queue.poll()[0]);
             }
      }
      return time;

    }
}