class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int start = 0;
        int end = cells.length -1;
        int ans = 0;
        while(start <= end)
        {
            int mid = (start+end)/2;
            if(canReach(mid,cells,row,col)){
                start = mid + 1;
                ans = mid;
            }else{
                end = mid-1;
            }
        }
        return ans + 1;
    }

    public boolean canReach(int mid,int[][] cells,int row,int col){
        int[][] grid = new int[row][col];
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<=mid;i++)
        {
            grid[cells[i][0]-1][cells[i][1]-1] = 1;
        }

        for(int i=col-1;i>=0;i--)
        {
            if(grid[0][i] == 0)
            {
                queue.offer(new int[]{0,i});
                grid[0][i] = 1;
            }
        }

        while(!queue.isEmpty()){
            int[] pt = queue.poll();
            for(int j=0;j<4;j++)
            {
                int x = pt[0] + dx[j];
                int y = pt[1] + dy[j];
                if(x<0 || x>=row || y<0 || y>=col || grid[x][y] == 1) continue;

                if(x == row -1) return true;

                grid[x][y] = 1;
                queue.offer(new int[]{x,y});
            }
        }
        return false;
    }
}