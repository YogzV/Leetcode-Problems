class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
     
        char[][] board = new char[n][n];
        
        for(int i=0;i<n;i++){
           
            Arrays.fill(board[i],'.');
        }
        
        backtrack(board,0);
        return res;
        
    }

    public void backtrack(char[][] board,int row){

        int n = board.length;
        
        if(row == n)
         {
            List<String> list = new ArrayList<>();
            for(char[] r : board)
                list.add(new String(r));
               
            res.add(list);
            return;
            
         }

        for(int i=0;i<n;i++){

            boolean notpres = !findQueen(board,row,i);
                            
           if(notpres){
            
             board[row][i] = 'Q';
             backtrack(board,row+1);
             board[row][i] = '.';
           }
        }
        return;
    }

    public boolean findQueen(char[][] board,int row,int col){
         int n = board.length;
         int r = row;
         int c = col;
        while(r-- > 0 && c-- > 0){
            if(board[r][c] == 'Q')
             return true;
        }
        r = row;
        c = col;
        while(row-- >0 && col++ < n-1){
            if(board[row][col] == 'Q')
              return true;
        }
        while(r-- >0){
            if(board[r][c] == 'Q')
             return true; 
         }

        return false;
    }
}