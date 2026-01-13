class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> ans = new ArrayList<>();
        
        int i,j;
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        

        boolean[][] vis = new boolean[m][n];

        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(dfs(i,j,vis,1,heights)){
                    pacific[i][j] = true;
                }
            }
        }

        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(pacific[i][j] && dfs(i,j,vis,0,heights)){
                     ans.add(new ArrayList<>(Arrays.asList(i,j)));   
                }
            }
        } 
 
        
        return ans;        
    }

    public boolean dfs(int row,int col,boolean[][] vis,int pacific,int[][] heights){

        int m = heights.length;
        int n = heights[0].length;

    
        if(row == 0 || col==0){
            if(pacific == 1) 
              return true;
            
        }

        if(row == m-1 || col == n-1){
            if(pacific == 0)
              return true;           
        }
      
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        boolean res = false;

        for(int i=0;i<4;i++){
            int x = row+dx[i];
            int y = col+dy[i];
            if(x <0 || x>=m || y<0 || y>=n || heights[x][y] > heights[row][col] || vis[x][y])
              continue;

           vis[x][y] = true; 
           res = res || dfs(x,y,vis,pacific,heights);
           vis[x][y] = false; 
        }
            
        return res;

    }
}