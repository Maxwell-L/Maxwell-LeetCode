/**
 * 49.Group Anagrams
 *    Medium
 * Description:
 * Given an array of strings, group anagrams together.
 *
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *   All inputs will be in lowercase.
 *   The order of your output does not matter.
 */
 
class Solution {
    private int hash(String str){
        int result1 = 1, result2 = 0;
        for(int i = 0; i < str.length(); i++){
            result1 *= (int)str.charAt(i);
            result2 += (int)str.charAt(i);
        }
        return result1 + result2;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<Integer> keys = new ArrayList<Integer>();
        HashMap<Integer, List<String>> hm = new HashMap<Integer, List<String>>();
        for(String str : strs){
            int index = hash(str);
            if(hm.get(index) == null){
                keys.add(index);
                List<String> subResult = new ArrayList<String>();
                subResult.add(str);
                hm.put(index, subResult);
            }
            else{
                hm.get(index).add(str);
            }
        }
        for(Integer index : keys){
            result.add(hm.get(index));
        }
        return result;
    }
}
