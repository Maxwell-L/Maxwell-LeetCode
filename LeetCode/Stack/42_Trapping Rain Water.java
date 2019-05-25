/**
 * 42. Trapping Rain Water
 * Hard
 * Description:
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * 
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
 
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
