class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        int[] tempQ = Arrays.copyOf(queries,queries.length);
        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        Map<Integer,Integer> hmap = new HashMap<>();

        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        Arrays.sort(queries);
        
        int size = intervals.length;
        int qSize = queries.length;
       
        int i = 0;

        for(int queryInd = 0 ;queryInd < qSize;queryInd++){

            while(i<size && intervals[i][0] <= queries[queryInd]){
                    int l = intervals[i][0];
                    int r = intervals[i][1];
                    minHeap.offer(new int[]{r-l+1,r});
                    i++;
                }
            
            while(!minHeap.isEmpty() && minHeap.peek()[1] < queries[queryInd]){
                minHeap.poll();
            }

            hmap.put(queries[queryInd], (minHeap.isEmpty())? -1:minHeap.peek()[0] );
        }


        int[] ans = new int[qSize];
        for(i=0;i<qSize;i++){
            
            ans[i] = hmap.get(tempQ[i]);
        }

        return ans;

    }
}