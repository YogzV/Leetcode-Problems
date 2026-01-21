class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int total = 0;
        int gsum = 0;
        int csum = 0;
        int size = gas.length;
        for(int i=0;i < size;i++){
            gsum += gas[i];
            csum += cost[i];
        }
        if(gsum < csum) return -1;

        for(int i=0;i<size;i++){
          total += gas[i] - cost[i];
          if(total < 0){
            total = 0;
            start = i+1;
          }
        }

        return start;
    }
}