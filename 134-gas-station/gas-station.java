class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int total = 0;
        int gsum = Arrays.stream(gas).sum();
        int csum = Arrays.stream(cost).sum();
        if(gsum < csum) return -1;

        for(int i=0;i<gas.length;i++){
          total += gas[i] - cost[i];
          if(total < 0){
            total = 0;
            start = i+1;
          }
        }

        return start;
    }
}