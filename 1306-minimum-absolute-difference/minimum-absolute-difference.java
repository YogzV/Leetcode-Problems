class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        int size = arr.length;
        Arrays.sort(arr);

        int i;
        int minDiff = Integer.MAX_VALUE;

        for(i=0;i<size-1;i++){
            int val = Math.abs(arr[i+1] - arr[i]);
            if(val < minDiff){
                list.clear();
                list.add(Arrays.asList(arr[i],arr[i+1]));
                minDiff = val;
            }else if(val == minDiff){
                list.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }
        return list;
    }
}