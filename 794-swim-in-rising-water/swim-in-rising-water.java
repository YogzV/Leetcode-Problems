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
       int n = grid[0].length;
       
        boolean[][] vis = new boolean[m][n];
        int i;
        for(i=0;i<m;i++)
        {
            Arrays.fill(vis[i],false);
        }
      int[] dx = {-1,0,1,0};
      int[] dy = {0,1,0,-1};

       pqueue.offer(new Cell(0,0,grid[0][0]));
       vis[0][0] = true;
       int time=Integer.MIN_VALUE;
       while(!pqueue.isEmpty())
       {
         Cell cell = pqueue.poll();
         int r = cell.row;
         int c = cell.col;
         int v = cell.val;
         time = Math.max(time,grid[r][c]);
         
         if(grid[r][c] == grid[m-1][n-1])
         {
            break;
         }
         for(i=0;i<4;i++)
         {
          
            int  x = dx[i] + r;
            int y = dy[i] + c;
            
            if(x<m && x>=0 && y<n && y>=0 && !vis[x][y])
            {  
                vis[x][y] = true;
                pqueue.offer(new Cell(x,y,grid[x][y]));
            }
         }
       }
       return time;

    }
}