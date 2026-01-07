class Pair implements Comparable<Pair>{
    int ind;
    int dist;
    Pair(int ind ,int dist){
        this.ind = ind;
        this.dist = dist;
    }

    @Override
    public int compareTo(Pair other){
        return Integer.compare(other.dist,this.dist);
    }
}

class Solution {

    public int[][] kClosest(int[][] points, int k) {
        Queue<Pair> pqueue = new PriorityQueue<>();
        int[][] ans = new int[k][2];
 
        int ind = 0;
        for(int[] pt : points){
            
            pqueue.offer(new Pair(ind++,pt[0]*pt[0] + pt[1]*pt[1]));
            if(pqueue.size() > k){
                pqueue.poll();
            } 
        }
        
        while(k-- > 0){
          ans[k] = points[pqueue.poll().ind];
        }

        return ans;
    }

    
}