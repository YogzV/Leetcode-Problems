class Solution {
    public void solve(char[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;
        int i,j;
        for(i=0;i<n;i++){
            if(board[0][i] == 'O'){
                board[0][i] = 'M';
                queue.offer(new int[]{0,i});
            }
            if(board[m-1][i] == 'O'){
                board[m-1][i] = 'M';
                queue.offer(new int[]{m-1,i});
            }
        }
        for(i=0;i<m;i++){
           if(board[i][0] == 'O'){
            board[i][0] = 'M';
            queue.offer(new int[]{i,0});
           }
           if(board[i][n-1] == 'O'){
            board[i][n-1] = 'M';
            queue.offer(new int[]{i,n-1});
           }
        }

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        while(!queue.isEmpty()){
            int[] pt = queue.poll();
 
            for(i=0;i<4;i++){
                int x = pt[0] + dx[i];
                int y = pt[1] + dy[i];
                if(x<0 || y<0 || x>=m || y>=n || board[x][y] != 'O')
                  continue;
                
                queue.offer(new int[]{x,y});
                board[x][y] = 'M';
            }
        }

        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(board[i][j] == 'M'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
       return;
    }
}