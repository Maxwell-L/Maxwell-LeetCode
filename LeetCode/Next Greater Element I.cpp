class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& findNums, vector<int>& nums) {
        int len1 = findNums.size(), len2 = nums.size();
        vector<int> output(len1);
        for(int i = 0; i < len1; i++){
            int j = 0;
            while(nums[j] != findNums[i]){
                j++;
            }
            for(; j < len2; j++){
                if(nums[j] > findNums[i]){
                    output[i] = nums[j];
                    break;
                }
            }
            if(j == len2)
                output[i] = -1;
        }
        return output;
    }
};