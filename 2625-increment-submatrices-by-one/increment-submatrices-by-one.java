class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        int i,j,k;
        for(i = queries.length-1;i>=0;i--)
        {
            int stRow = queries[i][0];
            int stCol = queries[i][1];
            int enRow = queries[i][2];
            int enCol = queries[i][3];

            for(j=stRow;j<=enRow;j++)
            {
                for(k=stCol;k<=enCol;k++)
                {
                    mat[j][k]++;
                }
            }
            
        }
        return mat;
    }
}