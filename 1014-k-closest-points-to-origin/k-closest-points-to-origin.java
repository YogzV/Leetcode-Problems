class Solution {

    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pqueue = new PriorityQueue<>((a,b) -> Integer.compare(b[0]*b[0] + b[1]*b[1],a[0]*a[0] + a[1]*a[1]));
        int[][] ans = new int[k][2];
 
        
        for(int[] pt : points){
            
            pqueue.offer(pt);
            if(pqueue.size() > k){
                pqueue.poll();
            } 
        }
        
        while(k-- > 0){
          ans[k] = pqueue.poll();
        }

        return ans;
    }

    
}