class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,Set<Character>> row = new HashMap<>();
        HashMap<Integer,Set<Character>> col = new HashMap<>();
        HashMap<String,Set<Character>> grid = new HashMap<>();
        for(int i=0;i<9;i++)
        {
            for(int j = 0;j<9;j++)
            {
                if(board[i][j] == '.') continue;

                String gridval = (i/3) + "#" + (j/3);

                if(row.computeIfAbsent(i,k -> new HashSet<>()).contains(board[i][j]) 
                   || col.computeIfAbsent(j,k -> new HashSet<>()).contains(board[i][j]) || grid.
                    computeIfAbsent(gridval,k -> new HashSet<>()).contains(board[i][j]))
                 return false;

                row.get(i).add(board[i][j]);
                col.get(j).add(board[i][j]);
                grid.get(gridval).add(board[i][j]);
            }

           
        }
         return true;
    }
}