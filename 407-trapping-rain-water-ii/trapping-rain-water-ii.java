class Solution {

    public static class Cell implements Comparable<Cell>{
    int height;
    int r;
    int c;
    Cell(int h,int r,int c)
    {
        height = h;
        this.r = r;
        this.c = c;
    }

    @Override
    public int compareTo(Cell obj){
        return Integer.compare(this.height,obj.height);
    }
}


    public int trapRainWater(int[][] heightMap) {

if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) return 0;

        int row = heightMap.length;
        int col = heightMap[0].length;
        PriorityQueue<Cell> pqueue = new PriorityQueue<>();
         int i;
         int maxWater = 0;

        boolean[][] vis = new boolean[row][col];
        for(i=0;i<row;i++)
        {
            Arrays.fill(vis[i],false);
        }
    
        
        for(i=0;i<row;i++)
        {
            pqueue.offer(new Cell(heightMap[i][0],i,0));
            pqueue.offer(new Cell(heightMap[i][col-1],i,col-1));
            vis[i][0] = vis[i][col-1] = true;
        }

        for(i=1;i<col-1;i++)
        {
            pqueue.offer(new Cell(heightMap[0][i],0,i));
            pqueue.offer(new Cell(heightMap[row-1][i],row-1,i));
            vis[0][i] = vis[row-1][i] = true;
        }

        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};
        int x,y;

        while(!pqueue.isEmpty())
        {
           Cell obj = pqueue.poll();
           for(i=0;i<4;i++)
           {
             x = dx[i] + obj.r;
             y = dy[i] + obj.c;
            if(x<row && x>0 && y<col && y>0 && !vis[x][y])
            {
            
                maxWater += Math.max(0,obj.height-heightMap[x][y]);
                pqueue.offer(new Cell(Math.max(obj.height,heightMap[x][y]),x,y));
                vis[x][y] =true;
            }

           }

        }
        return maxWater;
        
    }
}

