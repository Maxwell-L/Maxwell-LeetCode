/** 
 * 60.Permutation Sequence
 *    Medium
 * Description:
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *   1."123"
 *   2."132"
 *   3."213"
 *   4."231"
 *   5."312"
 *   6."321"
 * Given n and k, return the kth permutation sequence.
 * Note:
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * 
 * Example 1:
 * Input: n = 3, k = 3
 * Output: "213"
 * 
 * Example 2:
 * Input: n = 4, k = 9
 * Output: "2314" 
 */

class Solution {
    private int fac(int n){
        int num = 1;
        while(n > 0){
            num *= n;
            n--;
        }
        return num;
    }
    public String getPermutation(int n, int k) {
        char[] result = new char[n];
        List<Character> arr = new ArrayList<Character>();
        for(int i = 1; i <= n; i++){
            arr.add((char)(i+'0'));
        }
        for(int i = 0, j = n-1; i < n; i++, j--){
            int temp = fac(j);
            int index = k <= temp ? 0 : (k - 1) / temp;
            result[i] = arr.get(index);
            arr.remove(index);
            k = k <= temp ? k : k - index * temp;
        }
        return String.valueOf(result);
    }
}
