//对于一个m * n的矩阵来说，该方法的时间复杂度为O(m+n)，但采用合适的二分法可将复杂度降低到O(log(mn))，待改进
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = row != 0 ? matrix[0].length : 0;
        if(col != 0){
            for(int i = 0; i < row; i++){
                if(matrix[i][col-1] < target){
                    continue;
                }
                for(int j = 0; j < col; j++){
                    if(matrix[i][j] == target){
                        return true;
                    }
                }
                break;
            }
        }   
        return false;
    }
}
