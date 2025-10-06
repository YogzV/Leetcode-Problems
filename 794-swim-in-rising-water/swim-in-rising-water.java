class Solution {

    class Cell implements Comparable<Cell>{
        int row;
        int col;
        int val;
        Cell(int row,int col,int val)
        {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public int compareTo(Cell obj)
        {
            return Integer.compare(this.val,obj.val);
        }
    }

    public int swimInWater(int[][] grid) {
        
       PriorityQueue<Cell> pqueue = new PriorityQueue<>();
       int m = grid.length;

        boolean[][] vis = new boolean[m][m];
        
      int[] dx = {-1,0,1,0};
      int[] dy = {0,1,0,-1};

       int time=0;
       int r,c,x,y,i;

       pqueue.offer(new Cell(0,0,grid[0][0]));
       vis[0][0] = true;
      
       while(!pqueue.isEmpty())
       {
         Cell cell = pqueue.poll();
         r = cell.row;
         c = cell.col;
         
         time = Math.max(time,grid[r][c]);
         
         if(grid[r][c] == grid[m-1][m-1])
         {
            break;
         }
         for(i=0;i<4;i++)
         {
          
             x = dx[i] + r;
             y = dy[i] + c;
            
            if(x<m && x>=0 && y<m && y>=0 && !vis[x][y])
            {  
                vis[x][y] = true;
                pqueue.offer(new Cell(x,y,grid[x][y]));
            }
         }
       }
       return time;

    }
}