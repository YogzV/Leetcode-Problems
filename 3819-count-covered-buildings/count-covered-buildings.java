class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        int[][] row = new int[2][n];
        int[][] col = new int[n][2];
        int i,j;
        int x,y;
        int min,max;
        int ans = 0;


         Arrays.fill(row[1],-1);
         Arrays.fill(row[0],-1);

       for(i=0;i<n;i++)
       {
       
        Arrays.fill(col[i],-1);
       }   

        for(i = buildings.length-1;i>=0;i--)
        {
            x = buildings[i][0] - 1;
            y = buildings[i][1] - 1 ;
            
            min = row[0][y] == -1 ?  x : Math.min(row[0][y],x);
            max = row[1][y] == -1 ? x: Math.max(row[1][y],x);
            row[0][y] = min;
            row[1][y] = max;

            min = col[x][0] ==-1? y : Math.min(col[x][0],y);
            max = col[x][1] == -1? y : Math.max(col[x][1],y);
            col[x][0] = min;
            col[x][1] = max;
        }
       
        // for(i=0;i<n;i++)
        // {
        //     for(j=0;j<n;j++)
        //     {
        //         System.out.print(city[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
       
        for(i = buildings.length-1;i>=0;i--)
        {
             x = buildings[i][0] - 1;
             y = buildings[i][1] - 1;

             if(x > row[0][y] && x < row[1][y] && y>col[x][0] && y<col[x][1])
              ans++;

        }
        return ans;
        

    }
}