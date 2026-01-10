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
           
            
            boolean notpres = !findRight(board,row,i) && 
                              !findLeft(board,row,i) &&
                              !findUp(board,row,i);

        //    System.out.println(row+" "+i+" "+notpres);
        //    if(row == 3){
        //     for(char[] r : board){
        //         for(char c : r){
        //             System.out.print(c+" ");
        //         }
        //         System.out.println();
        //     }
        //    }
                    
           if(notpres){
            
             board[row][i] = 'Q';
             

             backtrack(board,row+1);

             
             board[row][i] = '.';
             
           }
            
        }
        return;
    }

    public boolean findUp(char[][] board,int row,int col){
         while(row >=0){
            if(board[row][col] == 'Q')
             return true;

            row--;
         }
         return false;
    }

    public boolean findRight(char[][] board,int row,int col){
         int n = board.length;
        while(row >=0 && col < n){
            if(board[row][col] == 'Q')
             return true;
            row--;
            col++;
        }
        return false;
    }

    public boolean findLeft(char[][] board,int row,int col){
         int n = board.length;
        while(row >=0 && col >=0){
            if(board[row][col] == 'Q')
             return true;
            row--;
            col--;
        }
        return false;
    }
}