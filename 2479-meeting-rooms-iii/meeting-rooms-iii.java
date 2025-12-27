class Solution {
    public int mostBooked(int n, int[][] meetings) {

        int ans = 0;
        int[] rooms = new int[n];
        int[] avail = new int[n];
        int size = meetings.length;
        int i;
        int max = Integer.MIN_VALUE;
        long start,end;
        int room = -1;
        long[] pt;

        Queue<long[]> pqueue = new PriorityQueue<>((a,b) -> {
            if(a[0] > b[0] || (a[0] == b[0] && a[1] > b[1]))
             return 1;
        
            return -1;
        });

        Arrays.sort(meetings,Comparator.comparingInt(a -> a[0]));
        pqueue.offer(new long[]{(long)meetings[0][1],0});
        rooms[0]++;
        avail[0] = 1;
        
        for(i=1;i<size;i++)
        {
            start = (long)meetings[i][0];
            end = (long)meetings[i][1];
            
            while(!pqueue.isEmpty() && pqueue.peek()[0] <= start){
                pt = pqueue.poll();
                avail[(int)pt[1]] = 0;
            }
            room = roomsAvailable(avail);
            if(room != -1)
            {
               pqueue.offer(new long[]{end,room});
               rooms[room]++;
               avail[room] = 1;
            }else{
                 pt = pqueue.poll();
                 end += pt[0] - start;
                pqueue.offer(new long[]{end,pt[1]});
                rooms[(int)pt[1]]++;
            }
            

        }
       
        for(i=0;i<n;i++)
        {
           if(max < rooms[i] || (max==rooms[i] && ans > i))
           {
            max = rooms[i];
            ans = i;
           }
        }

       return ans;
       }

    public int roomsAvailable(int[] avail){
        int size = avail.length;
        int i;
        for(i=0;i<size;i++)
        {
            if(avail[i] ==0)
             return i;
        }
        return -1;
    }
}