class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int i,j;
        int len = energy.length;
        int max = Integer.MIN_VALUE;
        for(i=len-1;i>=len-k;i--)
        {
            int sum=0;
            for(j=i;j>=0;j-=k)
            {
                sum+=energy[j];
                max = Math.max(max,sum);
            }

        }
        return max;
    }
}