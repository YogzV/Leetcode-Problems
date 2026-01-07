class Pair implements Comparable<Pair>{
    int[] pt;
    double dist;
    Pair(int[] pt ,double dist){
        this.pt = pt;
        this.dist = dist;
    }

    @Override
    public int compareTo(Pair other){
        return Double.compare(other.dist,this.dist);
    }
}

class Solution {

    public int[][] kClosest(int[][] points, int k) {
        Queue<Pair> pqueue = new PriorityQueue<>();
        int[][] ans = new int[k][2];

        for(int[] pt : points){
            double dist = calculateDistance(pt[0],pt[1]);
            pqueue.offer(new Pair(pt,dist));
            if(pqueue.size() > k){
                pqueue.poll();
            } 
        }
        
        while(k-- > 0){
          ans[k] = pqueue.poll().pt;
        }

        return ans;
    }

    public double calculateDistance(int x1,int y1){
        int val = x1 * x1 + y1 * y1;
        return Math.sqrt(val);
    }
}