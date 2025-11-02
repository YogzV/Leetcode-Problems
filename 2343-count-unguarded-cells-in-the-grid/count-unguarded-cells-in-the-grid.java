class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        int i,j;
        int ans = 0;
        int row = walls.length;
        Queue<int[]> queue = new LinkedList<>();
        for(i=0;i<row;i++)
        {
            grid[walls[i][0]][walls[i][1]] = 1;
        } 
        row = guards.length;
        for(i=0;i<row;i++)
        {
            grid[guards[i][0]][guards[i][1]] = 1;
            queue.offer(new int[]{guards[i][0] , guards[i][1]});
        }
  
         while(!queue.isEmpty())
         {
           int[] pt = queue.poll();
           int x = pt[0];
           int y = pt[1];
           TraverseUpOrDown(grid,x,y,1);
           TraverseUpOrDown(grid,x,y,-1);
           TraverseRightOrLeft(grid,x,y,1);
           TraverseRightOrLeft(grid,x,y,-1);
          
         }
           
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(grid[i][j] == 0)
                 ans++;
            }
        }
        return ans;
    }

    private static void TraverseUpOrDown(int[][] grid,int row,int col,int mov){
         int size = grid.length;
         row += mov;
         while(row>=0 && row<size)
         {
             if(grid[row][col]==0)
             {
                grid[row][col] = -1;
             }else if(grid[row][col] == -1){
                   row +=mov;
                   continue; 
                }else{
                break;
             }
             row+=mov;
         }
    }
    
    private static void TraverseRightOrLeft(int[][] grid,int row,int col,int mov){
           int size = grid[0].length;
           col+=mov;
         while(col>=0 && col<size)
         {
             if(grid[row][col]==0)
             {
                grid[row][col] = -1;
             }else if(grid[row][col] == -1)
             {
                col+=mov;
                continue;
             }else{
                break;
             }
             col+=mov;
         }
    }
}