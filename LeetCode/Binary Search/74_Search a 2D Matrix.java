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
//*******O(log(mn))解法**采用二分查找算法*********************//
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = row != 0 ? matrix[0].length : 0;
        int left = 0, right = row * col - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(matrix[mid / col][mid % col] < target){
                left = mid + 1;
            }
            else if(matrix[mid / col][mid % col] > target){
                right = mid - 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
