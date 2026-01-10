class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
      res = new ArrayList<>();
      List<String> currList = new ArrayList<>();
      helper(s,0,currList);
      return res;
        
    }

    public void helper(String s,int ind,List<String> currList){

        if(ind >= s.length()){
            res.add(new ArrayList<>(currList));
            return;
        }
        
        for(int i=ind;i<s.length();i++){
            if(checkPalindrome(s,ind,i)){
                currList.add(s.substring(ind,i+1));
                helper(s,i+1,currList);
                currList.remove(currList.size() -1);
            }
        }
        return;
    }

    public boolean checkPalindrome(String s,int left,int right){
         while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
         }
         return true;
    }

}