class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i;
        int row = matrix.length;
        int col = matrix[0].length;
        int ind = -1;
        
        int start = 0;
        int end = row - 1;
        int mid;

        while(start <= end)
        {
            mid = (start+end)/2;
            if(matrix[mid][col-1] == target){
                return true;
            }else if(matrix[mid][col-1] > target)
            {
                 ind = mid;
                 end = mid-1;
            }else{
                start = mid+1;
            }
        }        

        if(ind == -1)
         return  false;
        
        start = 0;
        end = col -1;
        
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