class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int size = nums.length;
        int n = size/ 2;
        for(int num : nums){
            hmap.merge(num,1,Integer::sum);
            if(hmap.get(num) == n)
             return num;
        }
        return 0;
    }
}