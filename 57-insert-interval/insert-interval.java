class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        List<int[]> ans = new ArrayList<>();
        if(intervals.length == 0)
         return new int[][]{newInterval};

         boolean merged = false;
        for(int[] in : intervals){
            if(!merged && in[0] > newInterval[0]){
              list.add(newInterval);
              merged = true;
            }
            list.add(in);
        }

        if(!merged)
         list.add(newInterval);
        
        int size = list.size();
    
        int j = 1;
        ans.add(list.get(0));
        int i = 0;
        while(j < size){
            int[] pt1 = ans.get(i);
            int[] pt2 = list.get(j);
            if(pt1[1] >= pt2[0]){
                
                ans.remove(i);
                ans.add(new int[]{Math.min(pt1[0],pt2[0]) , Math.max(pt1[1],pt2[1])});
                
            }else{
                ans.add(pt2);
                i++;
            }
            j++;
        }

        int s = ans.size();
        int[][] res = new int[s][2];
        int ind = 0;
        for(int[] row : ans){
            res[ind][0] = row[0];
            res[ind++][1] = row[1];
        }
        return res;
        
    }
}