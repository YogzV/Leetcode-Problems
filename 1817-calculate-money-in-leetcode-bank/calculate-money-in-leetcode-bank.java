class Solution {
    public int totalMoney(int n) {
        
        int ans = 0;
        int money = 1;
        int cnt = 0;
        int sub = 2;
        while(n-- > 0)
        {
            ans+=money;
            cnt++;
            money++;
            if(cnt%7==0)
            {
                money = sub;
                sub++;
                cnt = 0;
            }
        }


        return ans;
    }
}