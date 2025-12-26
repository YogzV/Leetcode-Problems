class Solution {
    public int bestClosingTime(String customers) {

        int size = customers.length();
        int totalN = 0;
        int totalY = 0;
        int min = Integer.MAX_VALUE;
        int ans = 0;
        
       for(char ch : customers.toCharArray())
          totalY = (ch=='Y')? totalY++:totalY;
    
        
        for(int i=0;i<=size;i++)
        {
            if(i>0 && customers.charAt(i-1) == 'N')
               totalN++;
           
            if(totalN + totalY  < min)
            {
                min = totalN + totalY ;
                ans = i;
            }

            if(i<size && customers.charAt(i) == 'Y')
                totalY--;
             
        }
        

        return ans;
    }
}