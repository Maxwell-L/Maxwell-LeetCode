/**
 * 52.N-Queens II
 *    Hard
 * Description:
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example:
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */

class Solution {
    private void helper(int[] result, int[] col, boolean[] check, boolean[] add, boolean[] sub, int last, int count, int n){
        if(count == n){
            result[0]++; 
            return;
        }
        for(int j = 0; j < n; j++){
            if(!check[j] && !add[j+count] && !sub[j-count-1+n] && j != last && j != last-1 && j != last+1){
                add[j+count] = true;
                sub[j-count-1+n] = true;
                col[count] = j+1;
                check[j] = true;
                helper(result, col, check, add, sub, j, count+1, n);
                check[j] = false;
				col[count] = 0;
                sub[j-count-1+n] = false;
				add[j+count] = false;
            }
        }
    }
    public int totalNQueens(int n) {
        int[] result = new int[1];
        helper(result, new int[n], new boolean[n], new boolean[2*n-1], new boolean[2*n-1], -2, 0, n);
        return result[0];
    }
}
