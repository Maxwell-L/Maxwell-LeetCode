/**
 * 347.Top K Frequent Elements
 *     Medium
 * Description:
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
 
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        Queue<HashMap.Entry<Integer, Integer>> priority = new PriorityQueue<HashMap.Entry<Integer, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());
        for(int i = 0; i < nums.length; i++){
            if(hashmap.get(nums[i]) == null){
                hashmap.put(nums[i], 1);
            }
            else{
                hashmap.put(nums[i], hashmap.get(nums[i]) + 1);
            }
        }
        priority.addAll(hashmap.entrySet());
        for(int i = 0; i < k; i++){
            result.add(priority.poll().getKey());
        }
        return result;
    }
}
