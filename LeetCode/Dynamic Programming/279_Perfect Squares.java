/**
 * 279.Perfect Squares
 *     Medium
 * Description:
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 *
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */

class Solution {
    public int numSquares(int n) {
        int[] f = new int[n+1];
        Arrays.fill(f, n+1);
        f[0] = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 1; i + j * j <= n; j++){
                f[i + j * j] = Math.min(f[i + j * j], f[i] + 1);
            }
        }
        return f[n];
    }
}
