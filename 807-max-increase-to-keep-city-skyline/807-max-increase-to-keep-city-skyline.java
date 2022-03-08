class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        
        int[] rowMax = new int[n];
        int[] colMax = new int[n];
        
        for(int i=0;i<n;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                if(grid[i][j]>max) max = grid[i][j];
            }
            rowMax[i] = max;
        }
        
        
        for(int i=0;i<n;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                if(grid[j][i]>max) max = grid[j][i];
            }
            colMax[i] = max;
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