class Solution {
    public int maxProfit(int[] prices) {
        int fp=0;
        int sp=1;
        int profit = 0;
        int len = prices.length;
        while(sp< len){

            if(prices[sp] > prices[fp]){
                profit = Math.max(profit,prices[sp] - prices[fp]);
            }else{
                fp = sp;
            }
            sp++;
        }
        return profit;
    }
}