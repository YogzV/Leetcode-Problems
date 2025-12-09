class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i;
        int row = matrix.length;
        int col = matrix[0].length;
        int ind = -1;
        
        for(i=0;i<row;i++)
        {
            if(matrix[i][col-1] > target){
                ind = i;
                break;
            }else if(matrix[i][col - 1] == target)
            {
                return true;
            }
        }

        if(ind == -1)
         return  false;
        
        int start = 0;
        int end = col - 1;
        int mid;
        while(start <= end)
        {
           mid = (start+end) /2;
           if(matrix[ind][mid] == target){
            return true;
           }else if(matrix[ind][mid] < target){
            start = mid +1;
           }else{
            end = mid - 1;
           }
        }
        return false;

    }
}