class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        // Use 1D arrays instead of int[2][n] or int[n][2]
        int[] rowMin = new int[n];
        int[] rowMax = new int[n];
        int[] colMin = new int[n];
        int[] colMax = new int[n];

        // Initialize
        Arrays.fill(rowMin, n);
        Arrays.fill(colMin, n);
        Arrays.fill(rowMax, -1);
        Arrays.fill(colMax, -1);

        // Precompute row and column boundaries
        for (int[] pt : buildings) {
            int x = pt[0] - 1;
            int y = pt[1] - 1;

            rowMin[y] = Math.min(rowMin[y], x);
            rowMax[y] = Math.max(rowMax[y], x);

            colMin[x] = Math.min(colMin[x], y);
            colMax[x] = Math.max(colMax[x], y);
        }

        // Count covered points
        int ans = 0;

        for (int[] pt : buildings) {
            int x = pt[0] - 1;
            int y = pt[1] - 1;

            if (x > rowMin[y] && x < rowMax[y] &&
                y > colMin[x] && y < colMax[x]) {
                ans++;
            }
        }

        return ans;
    }
}
