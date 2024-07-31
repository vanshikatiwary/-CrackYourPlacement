class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++){ //traversing 0th col
            if( matrix[i][0] == 0) col0 = 0; //check if value at the 0th col at any    given row i = 0, take one col variable marked as false.
            for (int j = 1; j < cols; j++) // traversing 1st col
            if (matrix[i][j] == 0)
            matrix[i][0] = matrix[0][j] = 0; //leftmost & rightmost as 0
        }

        //traverse backward

        for (int i = rows - 1; i >= 0; i--){
            for(int j = cols - 1; j >= 1; j--)
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                matrix[i][j] = 0;
                if (col0 == 0) matrix[i][0] = 0;
            }
        }
    }

    
