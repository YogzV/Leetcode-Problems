class Solution {
    public int minSwaps(int[] nums) {
        HashMap<Integer,Integer> hmap = new HashMap<>();

        int size = nums.length;
        int i;

        for( i=0;i<size;i++){
            hmap.put(nums[i],i);
        }

        int[][] SArr = new int[size][2];
        for(i=0;i<size;i++){

            int temp = nums[i];
            int sum = 0;

            while(temp > 0){
               sum += (temp %10);
               temp /= 10;
            }

            SArr[i][0] = sum;
            SArr[i][1] = nums[i]; 
        }

        Arrays.sort(SArr, (a,b) -> {
            if( (a[0] > b[0]) || (a[0] == b[0] && a[1] > b[1]) )
             return 1;
            
            return -1;
        });

        int swaps = 0;
        

        for(i =0;i<size;i++){
            int[] temp = SArr[i];

            if(hmap.get(temp[1]) != i){
                swaps++;
                
                nums[hmap.get(temp[1])] = nums[i];
                hmap.replace(nums[i],hmap.get(temp[1]));
            }

        
             
        }

        return swaps;
    }
}