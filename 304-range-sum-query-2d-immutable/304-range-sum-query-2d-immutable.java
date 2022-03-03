class NumMatrix {

    int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        sumMatrix = new int[matrix.length][matrix[0].length];
        for(int i=matrix.length-1; i>=0; i--) {
            for(int j=matrix[0].length-1; j>=0; j--) {
                int sum = matrix[i][j];
                if(i+1<matrix.length)  sum+= sumMatrix[i+1][j];
                if(j+1<matrix[0].length) sum+= sumMatrix[i][j+1];
                if(i+1<matrix.length && j+1<matrix[0].length) sum-= sumMatrix[i+1][j+1];
                
                sumMatrix[i][j] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = sumMatrix[row1][col1];
        if(col2+1 < sumMatrix[0].length) {
            sum -= sumMatrix[row1][col2+1];
        }
        
        if(row2+1 < sumMatrix.length) {
            sum -= sumMatrix[row2+1][col1];
        }
        
        if(row2+1 < sumMatrix.length && col2+1 < sumMatrix[0].length) {
            sum += sumMatrix[row2+1][col2+1];
        }
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */