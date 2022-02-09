class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        performRotation(matrix,0,n-1,0,n-1);
    }
    public void performRotation(int[][] matrix, int colStart, int colEnd, int rowStart, int rowEnd){
        if(colStart>colEnd || rowStart>rowEnd) return;
        
        rotateSingle(matrix,colStart,colEnd,rowStart,rowEnd);
        performRotation(matrix,colStart+1,colEnd-1,rowStart+1,rowEnd-1);
    }
    
    void rotateSingle(int[][] matrix, int colStart, int colEnd, int rowStart, int rowEnd){
        int limit = colEnd-colStart;
        for(int offset = 0;offset<limit;offset++){
            int temp = matrix[rowStart][colStart+offset];
            matrix[rowStart][colStart+offset] = matrix[rowEnd-offset][colStart];
            matrix[rowEnd-offset][colStart] = matrix[rowEnd][colEnd-offset];
            matrix[rowEnd][colEnd-offset] = matrix[rowStart+offset][colEnd];
            matrix[rowStart+offset][colEnd] = temp;
        }
    }
}