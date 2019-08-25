/**
 * 933.Number of Recent Calls
 *     Easy
 * Description:
 * Write a class RecentCounter to count recent requests.
 * It has only one method: ping(int t), where t represents some time in milliseconds.
 * Return the number of pings that have been made from 3000 milliseconds ago until now.
 * Any ping with time in [t - 3000, t] will count, including the current ping.
 * It is guaranteed that every call to ping uses a strictly larger value of t than before.
 *
 * Example:
 * Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
 * Output: [null,1,2,3,3]
 *
 * Note:
 *   Each test case will have at most 10000 calls to ping.
 *   Each test case will call ping with strictly increasing values of t.
 *   Each call to ping will have 1 <= t <= 10^9.
 */
 
class RecentCounter {
    private Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        if(queue.peek() == null){
            queue.offer(t);
            return 1;
        }
        while(queue.peek() != null && t - 3000 > queue.peek()){
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
