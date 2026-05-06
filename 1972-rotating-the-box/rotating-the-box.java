class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] ans = new char[n][m];
        int ansj = 0,i,j,ansi;
        for(i=m-1;i>=0;i--){
            
            ansi = n-1;
            for(j=n-1;j>=0;j--){
                if(boxGrid[i][j] == '#'){
                   
                    ans[ansi][ansj] = '#';
                    ansi--;
                }else if(boxGrid[i][j] == '.'){
                    continue;
                }else{
                  
                   ansi = j-1;
                   ans[j][ansj] = '*';
                }
            }

            for(j = n-1;j>=0;j--){
                if(ans[j][ansj] == '\u0000'){
                    ans[j][ansj] = '.';
                }
            }
            ansj++;
        }

        return ans;
    }
}