class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int maxBottle = numBottles;
        int emptyBottles = numBottles;
        numBottles = 0;
        
        while(true)
        {
           while(numExchange <= emptyBottles)
           {
            emptyBottles -= numExchange;
            numBottles++;
            numExchange++;

           }
           if(numBottles ==0)  break;

           maxBottle += numBottles;
           emptyBottles += numBottles;
           numBottles = 0;
           
        }

        return maxBottle;
    }
}