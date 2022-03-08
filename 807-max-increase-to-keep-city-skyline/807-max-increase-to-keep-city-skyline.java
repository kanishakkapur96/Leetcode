class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        
        int[] rowMax = new int[n];
        int[] colMax = new int[n];
        
        for(int r = 0; r < n; ++r){
            for(int c = 0; c < n; ++c) {
                rowMax[r] = Math.max(rowMax[r], grid[r][c]);
                colMax[c] = Math.max(colMax[c], grid[r][c]);
            }
        }
        
        int maxInc = 0;
        for(int i=0;i<n;i++){
            for(int j = 0;j<n;j++){
                maxInc += Math.min(rowMax[i]-grid[i][j], colMax[j]-grid[i][j]);
            }
        }
        
        return maxInc;
    }
}