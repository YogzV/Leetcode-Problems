class Solution {
    public int maxDistance(int[] colors) {

        int ans = 0;
        int i;
        int j;
        int size = colors.length;

        for(i=0;i<size-1;i++){
            for(j=size-1;j>i;j--){
                if(colors[i] != colors[j]){
                    ans = Math.max(ans,j-i);
                    break;
                }
                 
            }
        }
       
        return ans;
    }
}