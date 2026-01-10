class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int i,j;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){

                if(word.charAt(0) == board[i][j]){
                    boolean[][] vis = new boolean[m][n];
                    if(helper(board,i,j,0,word,vis)){
                        return true;                   
                    }
                }
            }
        }

        return false;
    }

    public boolean helper(char[][] board,int row,int col,int cnt,String word,boolean[][] vis){
        if(cnt == word.length()){
            return true;
        }
        int m = board.length;
        int n = board[0].length;

        if(row>=0 && row<m && col<n && col>=0 &&
            vis[row][col] == false && 
            board[row][col] == word.charAt(cnt)){

            vis[row][col] = true;

            if(helper(board,row+1,col,cnt+1,word,vis) ||helper(board,row-1,col,cnt+1,word,vis) || helper(board,row,col+1,cnt+1,word,vis) ||helper(board,row,col-1,cnt+1,word,vis)){
                return true;
            }

            vis[row][col] = false;
            return false;
            
                
        }

        return false;
    }
}