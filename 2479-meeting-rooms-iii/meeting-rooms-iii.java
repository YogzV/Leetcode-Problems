class Pair{
    long end;
    int roomNo;
    Pair(long end,int roomNo)
    {
        this.end = end;
        this.roomNo = roomNo;
    }
}

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
       

        Queue<Pair> pqueue = new PriorityQueue<>((a,b) -> {
            if(a.end > b.end || (a.end == b.end && a.roomNo > b.roomNo))
             return 1;
        
            return -1;
        });

        Arrays.sort(meetings,Comparator.comparingInt(a -> a[0]));
        
        
        
        for(i=0;i<size;i++)
        {
            start = meetings[i][0];
            end = meetings[i][1];
            
            while(!pqueue.isEmpty() && pqueue.peek().end <= start){
                avail[pqueue.poll().roomNo] = 0;
            }
            
            room = roomsAvailable(avail);
            if(room != -1)
            {
               pqueue.offer(new Pair(end,room));
               rooms[room]++;
               avail[room] = 1;
            }else{
                 Pair pt = pqueue.poll();
                 end += pt.end - start;
                pqueue.offer(new Pair(end,pt.roomNo));
                rooms[pt.roomNo]++;
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