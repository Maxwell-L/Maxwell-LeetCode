/**
 * 128.Longest Consecutive Sequence
 *     Hard
 * Description:
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
 
class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int n : nums){
            if(!hm.containsKey(n)){
                int left = hm.containsKey(n - 1) ? hm.get(n-1) : 0;
                int right = hm.containsKey(n + 1) ? hm.get(n+1) : 0;
                int sum = left + right + 1;
                result = Math.max(sum, result);
                hm.put(n, sum);
                hm.put(n - left, sum);
                hm.put(n + right, sum);
            }
            else{
                continue;
            }
        }
        return result;
    }
}
