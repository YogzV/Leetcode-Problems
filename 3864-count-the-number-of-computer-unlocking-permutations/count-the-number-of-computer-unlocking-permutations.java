class Solution {
    public int countPermutations(int[] complexity) {
        long ans = 1;
        long MOD = 1000000007;
        int size = complexity.length;
        int count = 0;
        for(int i = 1;i<size;i++)
        {
            if(complexity[i] <= complexity[0]){
                return 0;
            }

            count++;
        }

        for(int i = 2;i<=count ;i++)
        {
            ans *= i;
            ans = ans % MOD;
        }

        return (int)(ans%MOD);
    }
}