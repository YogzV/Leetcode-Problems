public class cell{
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

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int row = heightMap.length;
        int col = heightMap[0].length;
        PriorityQueue<cell> pqueue = new PriorityQueue<>(Comparator.comparingInt(obj -> obj.height));

        int i;
        int maxWater = 0;

        boolean[][] vis = new boolean[row][col];
        for(i=0;i<row;i++)
        {
            Arrays.fill(vis[i],false);
        }
        
        for(i=0;i<row;i++)
        {
            pqueue.offer(new cell(heightMap[i][0],i,0));
            pqueue.offer(new cell(heightMap[i][col-1],i,col-1));
            vis[i][0] = vis[i][col-1] = true;
        }

        for(i=1;i<col-1;i++)
        {
            pqueue.offer(new cell(heightMap[0][i],0,i));
            pqueue.offer(new cell(heightMap[row-1][i],row-1,i));
            vis[0][i] = vis[row-1][i] = true;
        }

        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};

        while(!pqueue.isEmpty())
        {
           cell obj = pqueue.poll();
           for(i=0;i<4;i++)
           {
            int x = dx[i] + obj.r;
            int y = dy[i] + obj.c;
            if(x<row && x>0 && y<col && y>0 && !vis[x][y])
            {
                maxWater += Math.max(0,obj.height-heightMap[x][y]);
                pqueue.offer(new cell(Math.max(obj.height,heightMap[x][y]),x,y));
                vis[x][y] = true;
            } 

           }

        }



        return maxWater;
        
    }
}

