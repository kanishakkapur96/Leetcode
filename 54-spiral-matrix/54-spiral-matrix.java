class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int n = matrix.length;
        int m =  matrix[0].length;
        int[][] visited=  new int[n][m];
        
        int row = 0,col = 0;
        result.add(matrix[row][col]);
        visited[row][col] = 1;
        while(result.size()!=n*m){
            while(col+1<m && visited[row][col+1] == 0){
                result.add(matrix[row][col+1]);
                visited[row][col+1] = 1;
                col = col+1;
            }
            
            while(row+1<n && visited[row+1][col] == 0){
                result.add(matrix[row+1][col]);
                visited[row+1][col] = 1;
                row = row+1;
            }
            
            while(col-1>=0 && visited[row][col-1] == 0){
                result.add(matrix[row][col-1]);
                visited[row][col-1] = 1;
                col=col-1;
            }
            
            while(row-1>=0 && visited[row-1][col] == 0){
                result.add(matrix[row-1][col]);
                visited[row-1][col] = 1;
                row = row-1;
            }
        }
        
        return result;
    }
}