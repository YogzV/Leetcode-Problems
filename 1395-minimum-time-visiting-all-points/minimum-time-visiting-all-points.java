class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        int i;
        int n = points.length;

        for(i=0;i<n-1;i++){
            int pt1x = points[i][0];
            int pt1y = points[i][1];
            int pt2x = points[i+1][0];
            int pt2y = points[i+1][1];

            while(pt1x != pt2x || pt1y != pt2y){
                if(pt1x == pt2x){
                    time += (Math.max(pt1y,pt2y)-Math.min(pt2y,pt1y));
                    break;
                }else if(pt1y == pt2y){
                    time += (Math.max(pt1x,pt2x) - Math.min(pt1x,pt2x));
                    break;
                }

                if(pt1y< pt2y){
                    pt1y++;
                }else{
                    pt1y--;
                }
                
                if(pt1x < pt2x){
                    pt1x++;
                }else{
                    pt1x--;
                }

                time++;
            }
        }

        return time;
    }
}