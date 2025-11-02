class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        
        int ans = m*n;
      
        Queue<int[]> queue = new LinkedList<>();
        for(int i=walls.length-1;i>=0;i--)
        {
            grid[walls[i][0]][walls[i][1]] = 1;
            ans--;
        } 
       
        for(int i=guards.length-1;i>=0;i--)
        {
            grid[guards[i][0]][guards[i][1]] = 1;
            ans--;
            queue.offer(new int[]{guards[i][0] , guards[i][1]});
        }
  
         while(!queue.isEmpty())
         {
           int[] pt = queue.poll();
           int x = pt[0];
           int y = pt[1];
           ans = Traverse(grid,x,y,1,1,ans);
           ans = Traverse(grid,x,y,-1,1,ans);
           ans = Traverse(grid,x,y,1,0,ans);
           ans = Traverse(grid,x,y,-1,0,ans);
          
         }
           
       
        return ans;
    }

    private static int Traverse(int[][] grid,int row,int col,int mov,int dir,int ans){
         int m = grid.length;
         int n = grid[0].length;
         if(dir == 1)
         {
            row+=mov;
         }else{
            col+=mov;
         }
         while(row>=0 && row<m && col>=0 && col<n)
         {
             if(grid[row][col]==1)  break;
             else if(grid[row][col] == -1){
                      if(dir == 1)
           {
            row+=mov;
         }else{
            col+=mov;
         }
                   continue; 
            }else{
                grid[row][col] = -1;
                ans--;
             }
            if(dir == 1)
           {
            row+=mov;
         }else{
            col+=mov;
         }
         }
         return ans;
    }
    
}