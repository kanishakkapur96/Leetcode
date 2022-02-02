class Solution {
    public boolean exist(char[][] board, String word) {
        int numRow = board.length;
        int numCol = board[0].length;
        boolean[][] visited = new boolean[numRow][numCol];
        int[][] directions = new int[4][];
        directions[0] = new int[]{-1,0};
        directions[1] = new int[]{1,0};
        directions[2] = new int[]{0,-1};
        directions[3] = new int[]{0,1};
        
        for(int i=0;i<numRow;i++){
            for(int j = 0;j<numCol;j++){
                if(board[i][j] == word.charAt(0) && visited[i][j] == false){
                    if(dfs(i,j,board,1, word ,visited,directions)) return true;
                }
            }
        }
        return false;
    }
    
    boolean dfs(int row, int col,char[][] board, int index, String word, boolean[][] visited, int[][] directions){
        visited[row][col] = true;
        if(index == word.length()) return true;
        
        for(int i= 0;i<4;i++){
            int r = row+directions[i][0];
            int c = col + directions[i][1];
            if(r>=0 && r<board.length && c>=0 && c<board[0].length && board[r][c] == word.charAt(index) && visited[r][c] == false){
                if(dfs(r,c,board,index+1,word,visited,directions)) return true;
            }
            
        }
        visited[row][col] = false;
        return false;
        
    }
}