class Solution {
    private void sudoku(char[][] board, boolean[][] row, boolean[][] col, int[] isFull, int nextRow, int nextCol){
        if(isFull[0] == 81){
            return;
        }
        int nextc = (nextCol+1) % 9;
        int nextr = nextc == 0 ? nextRow + 1 : nextRow;
		if(board[nextRow][nextCol] == '.'){
			boolean[] grid = new boolean[9];
			for(int i = 3 * (nextRow / 3); i < 3 *(1 + nextRow / 3); i++){
			   for(int j = 3 * (nextCol / 3); j < 3 * (1 + nextCol / 3); j++){
				   if(board[i][j] != '.'){
						grid[(int)(board[i][j]-'0')-1] = true;
					}
				}
			}
			for(int num = 0; num < 9; num++){
				if(!row[nextRow][num] && !col[nextCol][num] && !grid[num]){
				   row[nextRow][num] = true;
				   col[nextCol][num] = true;
				   board[nextRow][nextCol] = (char)((num+1) + '0');
				   isFull[0]++;
				   sudoku(board, row, col, isFull, nextr, nextc);
				   if(isFull[0] == 81){
					   return;
				   }
				   board[nextRow][nextCol] = '.';
				   isFull[0]--;
				   row[nextRow][num] = false;
				   col[nextCol][num] = false;
				}
			}
		}
		else{			
			isFull[0]++;
			sudoku(board, row, col, isFull, nextr, nextc);
			if(isFull[0] == 81){
			   return;
			}
			isFull[0]--;
		}    
    }
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9], col = new boolean[9][9];
        int[] isFull = new int[1];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    row[i][(int)(board[i][j]-'0')-1] = true;
                    col[j][(int)(board[i][j]-'0')-1] = true;
                }
            }
        }
        sudoku(board, row, col, isFull, 0, 0);
    }
}
