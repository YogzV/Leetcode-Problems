class Solution {
    public int mostBooked(int n, int[][] meetings) {

        int ans = 0;
        int[] rooms = new int[n];
        int[] avail = new int[n];
        Queue<long[]> pqueue = new PriorityQueue<>((a,b) -> {
            if(a[0] > b[0] || (a[0] == b[0] && a[1] > b[1]))
             return 1;
        
            return -1;
        });

        Arrays.sort(meetings,Comparator.comparingInt(a -> a[0]));
        pqueue.offer(new long[]{(long)meetings[0][1],0});
        rooms[0]++;
        avail[0] = 1;
        
        for(int i=1;i<meetings.length;i++)
        {
            long start = (long)meetings[i][0];
            long end = (long)meetings[i][1];
            
            while(!pqueue.isEmpty() && pqueue.peek()[0] <= start){
                long[] pt = pqueue.poll();
                avail[(int)pt[1]] = 0;
            }
            int room = roomsAvailable(avail);
            if(room != -1)
            {
               pqueue.offer(new long[]{end,room});
               rooms[room]++;
               avail[room] = 1;
            }else{
                long[] pt = pqueue.poll();
                 end += pt[0] - start;
                pqueue.offer(new long[]{end,pt[1]});
                rooms[(int)pt[1]]++;
            }
            

        }
        int max = rooms[0];
        for(int i=1;i<n;i++)
        {
           if(max < rooms[i] || (max==rooms[i] && ans > i))
           {
            max = rooms[i];
            ans = i;
           }
        }

       return ans;
        // 1 - 1
        // 2 - 1
        // 3 - 2
        // 4 - 

        //   (12,2) (13,1) (10,3)
    }

    public int roomsAvailable(int[] avail){
        for(int i=0;i<avail.length;i++)
        {
            if(avail[i] ==0)
             return i;
        }
        return -1;
    }
}