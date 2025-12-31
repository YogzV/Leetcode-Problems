class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int i,j;
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for(i=0;i<=row-3;i++)
        {
            for(j=0;j<=col-3;j++)
            {
                System.out.println(sameColumnSum(grid,i,j));
              if(sameDiagonalSum(grid,i,j) && sameRowSum(grid,i,j) && sameColumnSum(grid,i,j)){
                ans++;
              }
            }
        }
        return ans;
    }

    public boolean sameColumnSum(int[][] grid,int row,int col){
        Set<Integer> set = new HashSet<>();
        int i,j;
        int sum = 0;
        for(i=col;i<col+3;i++){
            int total = 0;
            for(j=row;j<row+3;j++)
            {
                if(set.contains(grid[j][i]) || grid[j][i]>9 || grid[j][i]==0)
                  return false;
                
                set.add(grid[j][i]);
                total += grid[j][i];
            }
            if(i == col){
                sum = total;
            }else if(sum != total){
                return false;
            }
        }
        return true;
    }

    public boolean sameRowSum(int[][] grid,int row,int col){
        
        int i,j;
         int sum = 0;
        for(i=row;i<row+3;i++){
            int total = 0;
            for(j=col;j<col+3;j++)
            {
                if(grid[i][j]>9)
                 return false;
                
                total += grid[i][j];
            }
            if(i == row){
                sum = total;
            }else if(sum != total){
                return false;
            }
        }
        return true;
    }

    public boolean sameDiagonalSum(int[][] grid,int row,int col){
        int i,j;
        int sum = 0;
        for(i=row,j=col;i<row+3;i++,j++){
            sum += grid[i][j];
        }
        for(i=row,j=col+2;i<row+3;i++,j--){
            sum -= grid[i][j];
        }
        if(sum != 0)
         return false;

        return true;
    }
}