class Solution {
    public int bestClosingTime(String customers) {
        int size = customers.length();
        int[] prefix = new int[size+1];
        int[] suffix = new int[size+1];
        int i;
        int ans = 0;
        prefix[0] = 0;
        
        for(i=1;i<=size;i++)
        {
            prefix[i] = prefix[i-1];
          if(customers.charAt(i-1) == 'N')
          {
            prefix[i]++;
          }
        }
        suffix[size] = 0;
        suffix[size-1] = 0;
        for(i=size-2;i>=0;i--)
        {
            suffix[i] = suffix[i+1];
            if(customers.charAt(i+1) == 'Y')
            {
                suffix[i]++;
            } 
        }
        int min = Integer.MAX_VALUE;
        for(i=0;i<=size;i++)
        {
            int extra = 0;
            if(i<size && customers.charAt(i) == 'Y'){
             extra =1;
             }
             
          if(prefix[i] + suffix[i] + extra  < min)
          {
            min = prefix[i] + suffix[i] + extra;
            ans = i;
          }
        }
        

        return ans;
    }
}