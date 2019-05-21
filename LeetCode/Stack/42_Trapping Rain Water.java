class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0, result = 0, len = 0, sum = 0, count = 0;
        for(int i = 0; i < height.length; i++){
            if(stack.empty() && height[i] == 0){
                continue;
            }
            else if(!stack.empty() && height[i] >= max){
                if(len > 1){
                    sum = 0; count = 0;
                    while(stack.peek() != max){
                        sum += stack.pop();
                        count++;
                    }
                    result += max * count - sum;
                }
                stack.pop();
                max = height[i];
                stack.push(height[i]);
                len = 1;
            }
            else{
                max = stack.empty() ? height[i] : max;
                stack.push(height[i]);
                len++;
            }
        }
        if(stack.empty()){
            return result;
        }
        max = stack.pop(); sum = 0; count = 0; len = 0;
        while(!stack.empty()){
            if(stack.peek() >= max && len == 0){
                max = stack.pop();
            }
            else if(stack.peek() < max){
                sum += stack.pop();
                count++; len++;    
            }
            else{
                result += max * count - sum;
                sum = 0; count = 0; len = 0;
                max = stack.pop();
            }
        }
        return result;
    }
}
