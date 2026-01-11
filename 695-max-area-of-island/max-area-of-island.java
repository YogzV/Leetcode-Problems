class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int i,j;
        int m = grid.length;
        int n = grid[0].length;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(grid[i][j] == 1){
                   int val = bfs(grid,i,j,m,n);
                   
                   max = Math.max(max,val);
                }
            }
        }

        return max;
    }

    public int bfs(int[][] grid,int row,int col,int m,int n){
         
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        Queue<int[]> queue = new LinkedList<>();
  
        queue.offer(new int[]{row,col});
        grid[row][col] = 0;
        int val = 1;
        while(!queue.isEmpty()){
            int[] pt = queue.poll();
            
           
            for(int i=0;i<4;i++){

                int x = dx[i] + pt[0];
                int y = dy[i] + pt[1];
                if(x<0 || x>=m || y<0 || y>=n || grid[x][y]==0){
                    continue;
                }
                val++;
                 grid[x][y] = 0;
                queue.offer(new int[]{x,y});
            }
        }

        return val;
    }
}