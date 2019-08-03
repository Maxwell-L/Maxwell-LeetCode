/**
 * 231.Power of Two
 *     Easy
 * Description:
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 * Input: 1
 * Output: true 
 * Explanation: 20 = 1
 *
 * Example 2:
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 *
 * Example 3:
 * Input: 218
 * Output: false
 */
/** 
 * 位运算 2的倍数的2进制只有最左一位为1，其余为0，而2的倍数减1的二进制全为1，
 * 例如8的二进制是1000，8-1=7的二进制为0111，故两者异或会等于0
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }
}
