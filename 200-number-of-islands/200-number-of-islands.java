class Solution {
    
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int numOfIsland = 0;
        int[][] directions = new int[4][2];
        directions[0] = new int[]{-1,0};
        directions[1] = new int[]{1,0};
        directions[2] = new int[]{0,1};
        directions[3] = new int[]{0,-1};
        
        for(int i=0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    numOfIsland++;
                    bfs(i,j,grid,visited,directions);
                }
            }
        }
        return numOfIsland;
    }
    
    void bfs(int row, int col, char[][] grid, boolean[][] visited,int[][] direction){
        visited[row][col] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row,col});
        
        while(!q.isEmpty()){
            int[] point = q.poll();
            int c_row = point[0];
            int c_col = point[1];
            
            for(int i=0;i<4;i++){
                int r = c_row + direction[i][0];
                int c = c_col + direction[i][1];

                // check if valid case
                if(r>=0 && r<grid.length && c >= 0 && c<grid[0].length && grid[r][c] == '1' && visited[r][c] == false){
                    q.offer(new int[]{r,c});
                    visited[r][c] = true;
                }
            }
        }
    }
}