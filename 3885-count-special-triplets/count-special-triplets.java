class Solution {
    public int specialTriplets(int[] nums) {

        long MOD = 1000000007;
        HashMap<Integer,ArrayList<Integer>> hmap = new HashMap<>();
        int size = nums.length;
        long ans = 0;
        for(int i : nums)
        {
           hmap.putIfAbsent(i,new ArrayList<>(Arrays.asList(0,0)));
           hmap.get(i).set(0,hmap.get(i).get(0)+1);
        }
       
       for(int i : nums)
       {
          int target = i * 2;
          if(hmap.containsKey(target))
          {
             long prevAvail = hmap.get(target).get(1) ;
             long nextAvail = hmap.get(target).get(0) - hmap.get(target).get(1) ;
              
             if(i == target){
                nextAvail--;
             }

             ans += (prevAvail * nextAvail);
             System.out.println(ans);
          }
          
          int prev = hmap.get(i).get(1);
          hmap.get(i).set(1,prev+1);
       }

        return (int)(ans % MOD);
    }
}