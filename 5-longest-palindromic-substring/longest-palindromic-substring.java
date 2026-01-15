class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int i,j;
        int start = 0;
        int end = 0;
        int max = 1;

        for(i=0;i<len;i++){
            for(j=i+max;j<len;j++){
                if(checkPalindrome(s,i,j)){
                    start = i;
                    end = j;
                    max = j-i + 1;
                }
                
            }
        }

        return s.substring(start,end+1);
    }

    public boolean checkPalindrome(String s,int start,int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end))
             return false;

            start++;
            end--;
        } 
        return true;
    }
}