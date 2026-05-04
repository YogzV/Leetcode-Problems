class Solution {
    public boolean rotateString(String s, String goal) {
       if(s.length() != goal.length()) return false;    
        for(int i = 0;i<goal.length();i++){
            if(goal.charAt(0) == s.charAt(i)){
                String str = s.substring(i,goal.length()) + s.substring(0,i);
                if(str.equals(goal))
                  return true;
            }
        }
        return false;
    }
}