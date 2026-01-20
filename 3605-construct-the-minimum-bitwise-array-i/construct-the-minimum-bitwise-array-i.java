class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int i,j;
        int size = nums.size();
        int[] ans = new int[size];
        for(i=0;i<size;i++){
            ans[i] = -1;
            for(j=0;j<nums.get(i);j++){
                if( (j | (j+1)) == nums.get(i)){
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;
    }
}