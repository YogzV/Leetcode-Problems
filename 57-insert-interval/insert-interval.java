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
        int cnt = 0;
        while(j < size){
            int[] pt1 = list.get(i);
            if(pt1[0] == -1){
                j++;
                continue;
            }
           
            int[] pt2 = list.get(j);
           
            if(pt1[1] >= pt2[0]){
                pt1[0] = Math.min(pt1[0],pt2[0]);
                pt1[1] = Math.max(pt1[1],pt2[1]); 
                pt2[0] = -1;
                cnt++;
                  
            }else{
                i++;
            }
            j++;
        }
        int[][] res = new int[size-cnt][2];
        int ind= 0;

        for(int[] row : list){
            if(row[0] != -1){
                res[ind++] = row;
            }
        }
        return res;
        
    }
}