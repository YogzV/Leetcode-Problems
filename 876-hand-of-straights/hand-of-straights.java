class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)
         return false;
        
        Arrays.sort(hand);

        int size = hand.length;
        int total = 0;
        Map<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<size;i++){
            hmap.merge(hand[i],1,Integer::sum);
        }

        for(int i=0;i<size;i++){

            if(hmap.containsKey(hand[i])){
              
                for(int j=0;j<groupSize;j++){
                    int val = hand[i]+j;
                     
                    if(!hmap.containsKey(val)){
                      return false;
                    }
                    hmap.computeIfPresent(val,(k,v) -> (v==1) ? null : v-1);
                    total++;
                }
            }
           
            if(total == size)
             return true;
        }

        return false;
    }
}