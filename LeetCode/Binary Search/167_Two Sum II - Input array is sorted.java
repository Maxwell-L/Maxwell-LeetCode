class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        int temp = 0;
        for(int i = 0; i < numbers.length; i++){
            temp = target - numbers[i];
            if(hashmap.get(temp) != null){
                result[0] = hashmap.get(temp);
                result[1] = i + 1;
                return result;
            }
            hashmap.put(numbers[i], i+1);
        }
        return result;
    }
}
