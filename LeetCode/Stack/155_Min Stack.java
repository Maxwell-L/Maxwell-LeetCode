class MinStack {
    private int[] elem;
    private int size;
    private int len;
    private int minElem;
    /** initialize your data structure here. */
    public MinStack() {
        size = 1000;
        len = 0;
        elem = new int[size];
        minElem = 0;
    }
    
    public void push(int x) {
        if(len == 0){
            minElem = x;
        }
        else{
            minElem = minElem > x ? x : minElem;
        }
        if(len < size){
            elem[len++] = x;
        }
        else{
            int[] temp = new int[size * 2];
            size *= 2;
            for(int i = 0; i < len; i++){
                temp[i] = elem[i];
            }
            elem = temp;
            elem[len++] = x;
        }
    }
    
    public void pop() {
        int temp = elem[--len];
        if(temp == minElem && len != 0){
            temp = elem[0];
            for(int i = 1; i < len; i++){
                temp = temp < elem[i] ? temp : elem[i];
            }
            minElem = temp;
        }
    }
    
    public int top() {
        return elem[len-1];
    }
    
    public int getMin() {
        return minElem;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 