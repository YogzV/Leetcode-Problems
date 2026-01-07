class Pair implements Comparable<Pair>{
    int[] pt;
    int dist;
    Pair(int[] pt ,int dist){
        this.pt = pt;
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

        for(int[] pt : points){
            
            pqueue.offer(new Pair(pt,pt[0]*pt[0] + pt[1]*pt[1]));
            if(pqueue.size() > k){
                pqueue.poll();
            } 
        }
        
        while(k-- > 0){
          ans[k] = pqueue.poll().pt;
        }

        return ans;
    }

    
}