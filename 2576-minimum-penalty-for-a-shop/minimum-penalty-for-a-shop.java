class Solution {
    public int bestClosingTime(String customers) {
        int size = customers.length();
        int totalN = 0;
        int totalY = 0;
        int[] suffix = new int[size+1];
        int i;
        int ans = 0;
        
        for(i=0;i<size;i++)
        {
            if(customers.charAt(i) == 'Y')
            {
                totalY++;
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
           
          if(totalN + totalY  < min)
          {
            min = totalN + totalY ;
            ans = i;
          }
          if(i<size && customers.charAt(i) == 'Y'){
              totalY--;
             }
        }
        

        return ans;
    }
}