class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        int[][] row = new int[2][n];
        int[][] col = new int[n][2];
       
        int x,y;
      
        int ans = 0;


         Arrays.fill(row[1],-1);
         Arrays.fill(row[0],n);

       for(int i=0;i<n;i++)
       {
        Arrays.fill(col[i],-1);
       }   

        for(int i = buildings.length-1;i>=0;i--)
        {
            x = buildings[i][0] - 1;
            y = buildings[i][1] - 1 ;
            
            row[0][y] = Math.min(row[0][y],x);
            row[1][y] = Math.max(row[1][y],x);
            

            col[x][0] = ( col[x][0] ==-1? y : Math.min(col[x][0],y) );
            col[x][1] = ( col[x][1] == -1? y : Math.max(col[x][1],y) );
            
        }
       
     
        
       
        for(int i = buildings.length-1;i>=0;i--)
        {
             x = buildings[i][0] - 1;
             y = buildings[i][1] - 1;

             if(x > row[0][y] && x < row[1][y] && y>col[x][0] && y<col[x][1])
              ans++;

        }
        return ans;
        

    }
}