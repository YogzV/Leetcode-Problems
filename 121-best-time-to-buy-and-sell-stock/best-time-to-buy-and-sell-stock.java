class Solution {
    public int maxProfit(int[] prices) {
        int fp=0;
        int sp=1;
        int profit = 0;
        while(sp<prices.length){

            profit = Math.max(profit,prices[sp] - prices[fp]);
            if(prices[sp] < prices[fp]){
                fp = sp;
            }
            sp++;
        }
        return profit;
    }
}