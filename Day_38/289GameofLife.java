class Solution {
    
    public int TellMeActiveN(int[][] board, int i, int j)
    {
        int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        int count = 0;
        
        for(int l = 0;l<dirs.length;l++)
        {
            int row = i +  dirs[l][0];
            int col = j +  dirs[l][1];

            if(row >=0 && row < board.length && col >=0 && col < board[0].length && (board[row][col] == 1 || board[row][col] == -2))
                count++;
        }
        
        return count;
    }
    
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(board[i][j] == 1)
                {
                    int activeNeighbour = TellMeActiveN(board,i,j);
                    
                    if(activeNeighbour < 2 || activeNeighbour >3)
                        board[i][j] = -2;
                }
                else{
                    int activeNeighbour = TellMeActiveN(board,i,j);
                    
                    if(activeNeighbour == 3)
                        board[i][j] = 3;
                }
            }
        }
        
        
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(board[i][j] == -2)
                    board[i][j] = 0;
                else if(board[i][j] == 3)
                {
                    board[i][j] = 1;
                }
            }
        }
    }
}