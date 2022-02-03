class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int[] perimeter = new int[]{0};
        int[][] directions = new int[4][];
        directions[0] = new int[]{-1,0};
        directions[1] = new int[]{1,0};
        directions[2] = new int[]{0,1};
        directions[3] = new int[]{0,-1};
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    dfs(i,j,grid,visited,perimeter,directions);
                    return perimeter[0];
                }
            }
        }
        
        return perimeter[0];
    }
    
    void dfs(int row, int col, int[][] grid, boolean[][] visited, int[] perimeter, int[][] directions){
        visited[row][col] = true;
        
        // Check Perimeter
        //Check vertical
        if(row == 0 || grid[row-1][col] == 0){
            perimeter[0]+=1;
        }
        if(row == grid.length-1 || grid[row+1][col] == 0){
            perimeter[0]+=1;
        }
        
         //Check horizontal
        if(col == 0 || grid[row][col-1] == 0){
            perimeter[0]+=1;
        }
        if(col == grid[0].length-1  || grid[row][col+1] == 0){
            perimeter[0]+=1;
        }
        
        for(int i=0;i<4;i++){
            int r = row+directions[i][0];
            int c =col + directions[i][1];
            
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c] == 1 && visited[r][c] == false){
                dfs(r,c,grid,visited,perimeter,directions);
            }
        }
    }
    
}