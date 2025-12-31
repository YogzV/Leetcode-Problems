class Solution {
    public int countNegatives(int[][] grid) {
        int i,j;
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for(i=0;i<row;i++){
            for(j=0;j<col;j++){
              if(grid[i][j] < 0)
              {
                ans += (col-j);
                break;
              }
            }
        }
        return ans;
    }
}