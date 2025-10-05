class Solution {
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> list = new ArrayList<>();

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];   
    
        int i,j;
        for(i=0;i<m;i++)
        {    
            dfs(i,0,heights,pac,heights[i][0]);
            dfs(i,n-1,heights,atl,heights[i][n-1]);
            
        }

       for(i=0;i<n;i++)
       {
            dfs(0,i,heights,pac,heights[0][i]);
            dfs(m-1,i,heights,atl,heights[m-1][i]);
       }

       for(i=0;i<m;i++)
       {
        for(j=0;j<n;j++)
        {
            if(pac[i][j] && atl[i][j])
            {
                list.add(Arrays.asList(i,j));
            }
        }
       }

        return list;
    }

    public static void dfs(int i,int j,int[][] heights,boolean[][] vis,int value)
    {
        if(i>=heights.length || i<0 || j>=heights[0].length || j<0 || vis[i][j] || heights[i][j] < value ) 
        return;

        vis[i][j] = true;

        dfs(i+1,j,heights,vis,heights[i][j]);
        dfs(i,j+1,heights,vis,heights[i][j]);
        dfs(i-1,j,heights,vis,heights[i][j]);
        dfs(i,j-1,heights,vis,heights[i][j]);
    }
}