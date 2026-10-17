class Solution {
    public int minSwaps(int[] nums) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hmap.put(nums[i],i);
        }

        int[][] SArr = new int[nums.length][2];
        for(int i=0;i<nums.length;i++){

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
        int pos = 0;

        for(int i =0;i<nums.length;i++){
            int[] temp = SArr[i];

            if(hmap.get(temp[1]) != pos){
                swaps++;
                
                int pos1 = hmap.get(temp[1]);
                int num1 = temp[1];
                int num2 = nums[i];
                nums[pos1] = num2;
                nums[pos] = num1;
                hmap.replace(num1,pos);
                hmap.replace(num2,pos1);
            }
            
            pos++;
             
        }

        return swaps;
    }
}