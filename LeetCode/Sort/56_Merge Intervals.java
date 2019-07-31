/** 
 * 56.Merge Intervals
 *    Medium
 * Description:
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2){
            return intervals;
        }    
        Arrays.sort(intervals, Comparator.comparing(elem -> elem[0]));
        int[] temp = intervals[0];
        List<int[]> result = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][1] <= temp[1]){
                continue;
            }
            if(intervals[i][0] <= temp[1]){
                temp[1] = intervals[i][1];
            }
            else{
                result.add(temp);
                temp = intervals[i];
            }
        }
        result.add(temp);
        return result.toArray(new int[result.size()][]);
    }
}
