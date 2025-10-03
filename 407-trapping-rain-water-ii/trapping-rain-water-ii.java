class Solution {

    private static class cell{
    int height;
    int r;
    int c;
    cell(int h,int r,int c)
    {
        height = h;
        this.r = r;
        this.c = c;
    }
}


    public int trapRainWater(int[][] heightMap) {
        int row = heightMap.length;
        int col = heightMap[0].length;
        PriorityQueue<cell> pqueue = new PriorityQueue<>(Comparator.comparingInt(obj -> obj.height));

        int i;
        int maxWater = 0;

        int[][] vis = new int[row][col];
    
        
        for(i=0;i<row;i++)
        {
            pqueue.offer(new cell(heightMap[i][0],i,0));
            pqueue.offer(new cell(heightMap[i][col-1],i,col-1));
            vis[i][0] = vis[i][col-1] = 1;
        }

        for(i=1;i<col-1;i++)
        {
            pqueue.offer(new cell(heightMap[0][i],0,i));
            pqueue.offer(new cell(heightMap[row-1][i],row-1,i));
            vis[0][i] = vis[row-1][i] = 1;
        }

        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};
        int x,y;

        while(!pqueue.isEmpty())
        {
           cell obj = pqueue.poll();
           for(i=0;i<4;i++)
           {
             x = dx[i] + obj.r;
             y = dy[i] + obj.c;
            if(x>=row || x<0 || y>=col || y<0 || vis[x][y]==1)
            {
                continue;
            } else{
                maxWater += Math.max(0,obj.height-heightMap[x][y]);
                pqueue.offer(new cell(Math.max(obj.height,heightMap[x][y]),x,y));
                vis[x][y] =1;
            }

           }

        }



        return maxWater;
        
    }
}

