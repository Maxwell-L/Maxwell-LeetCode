/**
 * 118.Pascal's Triangle
 *     Easy
 * Description:
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * 
 * Example:
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = 1;
        List<Integer> last = new ArrayList<Integer>();
        while(n <= numRows){
            List<Integer> temp = new ArrayList<Integer>();
            for(int i = 0; i < n; i++){
                if(i == 0 || i == n - 1){
                    temp.add(1);
                }
                else{
                    temp.add(last.get(i-1) + last.get(i));
                }
            }
            result.add(temp);
            last = temp;
            n++;
        }
        return result;
    }
}