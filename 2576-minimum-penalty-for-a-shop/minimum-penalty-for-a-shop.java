class Solution {
    public int bestClosingTime(String customers) {
        int size = customers.length();
        int totalN = 0;
        int[] suffix = new int[size+1];
        int i;
        int ans = 0;
        
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
            if(i>0)
            {
                if(customers.charAt(i-1) == 'N')
                {
                    totalN++;
                }
            }
            int extra = 0;
            if(i<size && customers.charAt(i) == 'Y'){
             extra =1;
             }
             
          if(totalN + suffix[i] + extra  < min)
          {
            min = totalN + suffix[i] + extra;
            ans = i;
          }
        }
        

        return ans;
    }
}