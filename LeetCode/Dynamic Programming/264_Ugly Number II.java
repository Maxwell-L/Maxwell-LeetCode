/**
 * 264.Ugly Number II
 * Medium
 * Description:
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 *
 * Example:
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * 
 * Note:  
 *    1 is typically treated as an ugly number.
 *    n does not exceed 1690.
 */
 
class Solution {
    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        result[0] = 1;
        int two = 0, three = 0, five = 0;
        for(int i = 1; i < n; i++){
            result[i] = Math.min(Math.min(result[two] * 2, result[three] * 3), result[five] * 5);
            if(result[i] == result[two] * 2){
                two++;
            }
            if(result[i] == result[three] * 3){
                three++;
            }
            if(result[i] == result[five] * 5){
                five++;
            }
        }
        return result[n-1];
    }
}
