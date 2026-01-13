class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int i,j;

        List<List<Integer>> ans = new ArrayList<>();

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(i=0;i<n;i++){
            
            dfs(0,i,pacific,heights,0);
            dfs(m-1,i,atlantic,heights,0);
        }

        for(i=0;i<m;i++){
            
            dfs(i,0,pacific,heights,0);
            dfs(i,n-1,atlantic,heights,0);
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

    public void dfs(int row,int col,boolean[][] ocean,int[][] heights,int prev){
        if(row<0 || row>=heights.length || col<0 || col>= heights[0].length || heights[row][col] < prev || ocean[row][col])
         return;

        ocean[row][col] = true;

        dfs(row,col+1,ocean,heights,heights[row][col]);
        dfs(row,col-1,ocean,heights,heights[row][col]);
        dfs(row+1,col,ocean,heights,heights[row][col]);
        dfs(row-1,col,ocean,heights,heights[row][col]); 

        return;
    }
}