class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        if(intervals.length == 1)
         return intervals;
        
        int size = intervals.length;
        int i=0,j=1;
        int cnt = 0;
        while(j < size){
            int[] pt1 = intervals[i];
            int[] pt2 = intervals[j++];

            if(pt1[0] == -1)
             continue;

            if(pt1[1] >= pt2[0]){
                pt1[1] = Math.max(pt1[1],pt2[1]);
                pt2[0] = -1;
                cnt++;
            }else{
                 i = j-1;
                
            }
        }

        int[][] res = new int[size-cnt][2];
        int ind = 0;
        for(int[] row : intervals){
            if(row[0] != -1){
                res[ind++] = row;
            }
        }

        return res;

    }
}