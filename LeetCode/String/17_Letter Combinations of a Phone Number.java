/**
 * 17.Letter Combinations of a Phone Number
 *    Medium
 * Description:
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

class Solution {
    private void helper(List<String> result, int index, int len, List<String> ch, String digits, HashMap<Character, String> hm){
        if(index == len){
            if(len != 0){
                result.add(String.join("", ch));
            }
            return;
        }
        String str = hm.get(digits.charAt(index));
        for(int i = 0; i < str.length(); i++){
            List<String> newCh = new ArrayList<>(ch);
            newCh.add(String.valueOf(str.charAt(i)));
            helper(result, index+1, len, newCh, digits, hm);
        }
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> hm = new HashMap<Character, String>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        List<String> result = new ArrayList<String>();
        helper(result, 0, digits.length(), new ArrayList<String>(), digits, hm);
        return result;
    }
}
