class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] maxInd = new int[26];
        int len = s.length();
        int i;

        for(i=0;i<len;i++){
           maxInd[s.charAt(i) - 'a'] = i;
        }

        int left = 0;
        int right = 0;
        while(right < len){
            
            int cnt = 0;
            while(left <= right){
                right = Math.max(right,maxInd[s.charAt(left) - 'a']);
                left++;
                cnt++;
            }
            right = left;
            ans.add(cnt);
            
        }

        return ans;
    }
}