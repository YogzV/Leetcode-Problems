class Solution {
    public int minNumberOperations(int[] target) {
        int ans = target[0];
        int i ;
        int size = target.length;
        for(i = 1;i<size;i++)
        {
            if(target[i] > target[i-1])
            {
                ans += target[i]-target[i-1];
            }
        }
        return ans;
    }
}