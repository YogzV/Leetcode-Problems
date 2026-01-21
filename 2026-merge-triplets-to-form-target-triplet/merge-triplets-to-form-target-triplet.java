class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int size = triplets.length;
        int[] ans = new int[3];
        for(int i =0;i<size;i++){
             int[] tri = triplets[i];
             
             if(tri[0] > target[0] || tri[1] > target[1] || tri[2] > target[2])
              continue;
            
            ans[0] = Math.max(ans[0],tri[0]);
            ans[1] = Math.max(ans[1],tri[1]);
            ans[2] = Math.max(ans[2],tri[2]);
        }
        if(ans[0] == target[0] && ans[1] == target[1] && ans[2] == target[2])
              return true;
        return false;
    }
}