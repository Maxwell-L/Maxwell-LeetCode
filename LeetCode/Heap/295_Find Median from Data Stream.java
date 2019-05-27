/**
 * 295.Find Median from Data Stream
 *     Hard
 * Description:
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. 
 * So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Design a data structure that supports the following two operations:
 *   void addNum(int num) - Add a integer number from the data stream to the data structure.
 *   double findMedian() - Return the median of all elements so far.
 *
 * Example:
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3) 
 * findMedian() -> 2
 */

class MedianFinder {
    private Queue<Integer> priority, front;
    private int length;
    private double median;
    /** initialize your data structure here. */
    public MedianFinder() {
        priority = new PriorityQueue<Integer>();
        front = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        length = 0;
        median = 0;
    }
    
    public void addNum(int num) {
        length++;
        if(length % 2 == 1){
            priority.offer(num);
            if(length != 1)
                front.offer(priority.poll());
            median = priority.peek();
        }
        else{
            if(length == 2 || num > front.peek()){
                priority.offer(num);
                int temp = priority.poll();
                median = (temp + priority.peek()) / 2.0;
                priority.offer(temp);
            }
            else{
                median = (front.peek() + priority.peek()) / 2.0;
                priority.offer(front.poll());
                front.offer(num);
            }
        }
    }
    
    public double findMedian() {
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
