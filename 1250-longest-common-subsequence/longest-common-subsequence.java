class Solution {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for(int[] row : memo){
            Arrays.fill(row,-1);
        }
        return recur(text1,text2,0,0);
    }

    public int recur(String str1,String str2,int find,int sind){
        if(find == str1.length() || sind == str2.length())
         return 0;

        if(memo[find][sind] != -1)
         return memo[find][sind];
        
        
       int ans = 0;
       if(str1.charAt(find) == str2.charAt(sind)){
        ans = 1 + recur(str1,str2,find+1,sind+1);
       }else{
         ans = Math.max(ans,recur(str1,str2,find+1,sind));
         ans = Math.max(ans,recur(str1,str2,find,sind+1));
       }

       return memo[find][sind] = ans;
    }
}