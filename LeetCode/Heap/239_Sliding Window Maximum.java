/**
 * 239.Sliding Window Maximum
 *     Hard
 * Description:
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Example:
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7] 
 * Explanation: 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 0){
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> priority = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return i2-i1;
            }
        });
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            queue.offer(nums[i]);
            priority.offer(nums[i]);
            if(i >= k-1){
                result[index++] = priority.peek();
                priority.remove(queue.poll());
            }
        }
        return result;
    }
}
