class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int i,j;
        int len = energy.length;
        int val = len-k;
        int max = Integer.MIN_VALUE;
        int sum;
        for(i=len-1;i>=val;i--)
        {
            sum=0;
            for(j=i;j>=0;j-=k)
            {
                sum+=energy[j];
                max = Math.max(max,sum);
            }

        }
        return max;
    }
}