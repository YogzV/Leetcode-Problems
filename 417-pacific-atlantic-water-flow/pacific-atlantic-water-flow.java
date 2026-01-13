class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> ans = new ArrayList<>();
        
        int i,j;
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        boolean[][] vis = new boolean[m][n];

        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(dfs(i,j,vis,1,heights,Integer.MAX_VALUE)){
                    pacific[i][j] = true;
                }
            }
        }

        vis = new boolean[m][n];

        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(dfs(i,j,vis,0,heights,Integer.MAX_VALUE)){
                    atlantic[i][j] = true;
                }
            }
        } 
 
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                   ans.add(new ArrayList<>(Arrays.asList(i,j)));                    
                }
            }
        } 
        return ans;        
    }

    public boolean dfs(int row,int col,boolean[][] vis,int pacific,int[][] heights,int prev){

        int m = heights.length;
        int n = heights[0].length;

        if(row <0 || row>=m || col<0 || col>=n)
         return false;

        if(heights[row][col] > prev || vis[row][col] == true)
          return false;

        if(row == 0 || col==0){
            if(pacific == 1) 
              return true;
            
        }

        if(row == m-1 || col == n-1){
            if(pacific == 0)
             return true;           
        }

      

        vis[row][col] = true;
        boolean res = dfs(row,col+1,vis,pacific,heights,heights[row][col]) ||
                      dfs(row,col-1,vis,pacific,heights,heights[row][col]) || 
                      dfs(row+1,col,vis,pacific,heights,heights[row][col]) || 
                      dfs(row-1,col,vis,pacific,heights,heights[row][col]);

         vis[row][col] = false;  
        return res;

    }
}