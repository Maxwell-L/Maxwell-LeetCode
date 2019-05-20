class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] array = new int[row][col];
        for(int i = 0; i < col; i++){
            if(obstacleGrid[0][i] == 1){
                break;
            }
            array[0][i] = 1;
        }
        for(int i = 0; i < row; i++){
            if(obstacleGrid[i][0] == 1){
                break;
            }
            array[i][0] = 1;
        }
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(obstacleGrid[i][j] == 0){
                    array[i][j] = array[i-1][j] + array[i][j-1];
                }
            }
        }
        return array[row-1][col-1];
    }
}
