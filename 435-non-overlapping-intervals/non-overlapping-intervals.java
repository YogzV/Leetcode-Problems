class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
           if(a[0] != b[0])
            return a[0] - b[0];
           
           return a[1] - b[1];
        });

        int ans = 0;
        
        int j=1;
        int prevEnd = intervals[0][1];
        int size = intervals.length;
       
        while(j < size){
            if(prevEnd > intervals[j][0]){
                ans++;
                prevEnd = Math.min(intervals[j][1],prevEnd);
            }else{
                prevEnd = intervals[j][1];
            }
            j++;
        }
        return ans;
    }
}