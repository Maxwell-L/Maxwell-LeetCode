/**
 * 146.LRU Cache
 *     Hard
 * Description:
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *   get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 *   put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * The cache is initialized with a positive capacity.
*
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 * LRUCache cache = new LRUCache( 2 /* capacity */ );
 *   cache.put(1, 1);
 *   cache.put(2, 2);
 *   cache.get(1);       // returns 1
 *   cache.put(3, 3);    // evicts key 2
 *   cache.get(2);       // returns -1 (not found)
 *   cache.put(4, 4);    // evicts key 1
 *   cache.get(1);       // returns -1 (not found)
 *   cache.get(3);       // returns 3
 *   cache.get(4);       // returns 4
 */

class LRUCache {
    private HashMap<Integer, Integer> hm;
    private HashMap<Integer, Integer> keyToIndex;
    private HashMap<Integer, Integer> indexToKey;
    private Queue<Integer> priority;
    private int len;
    private int size;
    private int maxNum;
    public LRUCache(int capacity) {
        len = 0;
        size = capacity;
        hm = new HashMap<Integer, Integer>();
        keyToIndex = new HashMap<Integer, Integer>();
        indexToKey = new HashMap<Integer, Integer>();
        priority = new PriorityQueue<Integer>();
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            int index = keyToIndex.get(key);
            keyToIndex.put(key, ++maxNum);
            priority.remove(index);
            indexToKey.remove(index);
            indexToKey.put(maxNum, key);
            priority.offer(maxNum);
            return hm.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            hm.put(key, value);
            int index = keyToIndex.get(key);
            keyToIndex.put(key, ++maxNum);
            priority.remove(index);
            priority.offer(maxNum);
            indexToKey.remove(index);
            indexToKey.put(maxNum, key);
        }
        else if(len == size){
            int min = priority.poll();
            int k = indexToKey.get(min);
            indexToKey.remove(min);
            keyToIndex.remove(k);
            hm.remove(k);
            hm.put(key, value);
            keyToIndex.put(key, ++maxNum);
            indexToKey.put(maxNum, key);
            priority.offer(maxNum);
        }
        else{
            hm.put(key, value);
            keyToIndex.put(key, ++maxNum);
            indexToKey.put(maxNum, key);
            priority.offer(maxNum);
            len++;
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
