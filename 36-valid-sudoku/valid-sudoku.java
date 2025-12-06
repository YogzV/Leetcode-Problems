class Solution {
    public boolean isValidSudoku(char[][] board) {
        int i,j;
        for(i=0;i<9;i++)
        {
            Set<Character> set = new HashSet<>();
       
            for(j=0;j<9;j++)
            {
              if(board[i][j] != '.'){
               if(set.contains(board[i][j]))
                return false;
               set.add(board[i][j]);
              }
                
            }
            
        }
       

        for(i=0;i<9;i++)
        {
            Set<Character> set = new HashSet<>();
            for(j=0;j<9;j++)
            {
                if(board[j][i] != '.'){
               if(set.contains(board[j][i]))
                return false;
               set.add(board[j][i]);
                }
            }
        }
        

        for(i=0;i<9;i+=3)
        {
            for(j=0;j<9;j+=3)
            {
                Set<Character> set = new HashSet<>();
                for(int k = i;k<i+3;k++)
                {
                    for(int l = j;l<j+3;l++)
                    {
                        if(board[k][l] != '.'){
                      if(set.contains(board[k][l]))
                       return false;
                      set.add(board[k][l]);
                        }
                    }
                }
    }
    }
            
        
        return true;
    
    }

}