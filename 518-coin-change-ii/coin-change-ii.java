class Solution {
    int[][] memo;
    public int change(int amount, int[] coins) {
        memo = new int[coins.length][amount+1];
        for(int[] row : memo){
            Arrays.fill(row,-1);
        }
        return recur(coins,amount,0);
    }

    public int recur(int[] coins,int amount,int ind){
        if(amount == 0)
         return 1;
        
        if(ind >= coins.length)
         return 0;
        
        if(memo[ind][amount] != -1)
         return memo[ind][amount];

        int ans = recur(coins,amount,ind+1);

        for(int i = coins[ind] ; i <= amount ; i+= coins[ind]){
            ans += recur(coins,amount - i,ind+1);
        }

        return memo[ind][amount] = ans;
         
    }
}