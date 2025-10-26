class Bank {
     static HashMap<Integer,Long> hmap = new HashMap<>();
     static int size;
    public Bank(long[] balance) {
        int i;
        size = balance.length;
        for(i=0;i<size;i++)
        {
            hmap.put(i+1,balance[i]);
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1<1 || account1>size || account2<1 || account2>size|| hmap.get(account1) < money) return false;
        hmap.replace(account1,hmap.get(account1) - money);
        hmap.replace(account2,hmap.get(account2) + money);
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(account<1 || account> size) return false;
        hmap.replace(account,money+hmap.get(account));
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account<1 || account>size || hmap.get(account) < money) return false;
       
        hmap.replace(account,hmap.get(account) - money);
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */