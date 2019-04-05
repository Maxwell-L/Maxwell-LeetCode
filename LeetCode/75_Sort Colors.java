class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            count[nums[i]]++;
        }
        for(int i = 0; i < nums.length; i++){
            index = count[index] == 0 ? index + 1 : index;
            if(count[index] != 0){
                nums[i] = index;
                count[index]--; 
            }
            else{
                i--;
            }
        }
    }
}
