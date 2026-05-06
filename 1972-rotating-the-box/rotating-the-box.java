class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] ans = new char[n][m];
        int ansj = 0;
        for(int i=m-1;i>=0;i--){
            
            int ansi = n-1;
            for(int j=n-1;j>=0;j--){
                if(boxGrid[i][j] == '#'){
                   
                    ans[ansi][ansj] = '#';
                    ansi--;
                }else if(boxGrid[i][j] == '.'){
                    continue;
                }else{
                  
                   ansi = j;
                   ans[ansi][ansj] = '*';
                   ansi--;
                }
            }

            for(int j = n-1;j>=0;j--){
                if(ans[j][ansj] != '#' && ans[j][ansj] != '*'){
                    ans[j][ansj] = '.';
                }
            }
            ansj++;
        }

        return ans;
    }
}