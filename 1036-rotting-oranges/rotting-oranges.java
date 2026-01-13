class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for(int i = grid.length -1 ;i>=0;i--){
            for(int j = grid[0].length -1 ;j>=0;j--){
              if(grid[i][j] == 2){
                 queue.offer(new int[]{i,j,0});
                 grid[i][j] = 0;
              }else if(grid[i][j] == 1){
                fresh++;
              }
            }
        }

        int time = bfs(queue,fresh,grid);
        return time;
        
    }

    public int bfs(Queue<int[]> queue,int fresh,int[][] grid){

        int m = grid.length, n = grid[0].length; 
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int time = 0;
        while(!queue.isEmpty()){
            int[] pt = queue.poll();
            time = Math.max(time,pt[2]);
            for(int i=0;i<4;i++){
                int x = dx[i] + pt[0];
                int y = dy[i] + pt[1];
            

                if(x<0 || x>=m || y<0 || y>=n || grid[x][y] == 0){
                    continue;
                }

                grid[x][y] = 0;
                fresh--;
                queue.offer(new int[]{x,y,pt[2]+1});
            }    
        }

        if(fresh != 0)
          return -1;

         return time; 
        

    }
}