class Solution {
    int[][] memo;
    public int maxProfit(int[] prices) {
       memo  = new int[prices.length][2];
       for(int[] row : memo){
        Arrays.fill(row,-1);
       }
        return recur(prices,0,0);
    }

    public int recur(int[] prices,int ind,int buy){
        if(ind >= prices.length)
         return 0;
        
        int ans = 0;
        if(memo[ind][buy] != -1)
         return memo[ind][buy];
        
        if(buy == 0){
            ans = recur(prices,ind+1,0);
            ans = Math.max(ans,recur(prices,ind+1,1) - prices[ind]);
        }else{
           ans =  Math.max(ans,recur(prices,ind+2,0) + prices[ind]);
           ans = Math.max(ans,recur(prices,ind+1,1));
        }

        return memo[ind][buy] = ans;

        
    }
}