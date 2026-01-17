class Solution {
    HashMap<Integer,Integer> hmap = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int coin = recur(coins,amount);
        return (coin >= 1e7)? -1 : coin;

    }

    public int recur(int[] coins,int amount){

        if(hmap.containsKey(amount))
         return hmap.get(amount);

        if(amount == 0)
         return 0;

        int res = (int)1e7;

        for(int coin : coins){
            if(amount - coin >= 0){
                res = Math.min(res,1 + recur(coins,amount-coin));
            }
        }
        hmap.put(amount,res);
        return res;
    }
}