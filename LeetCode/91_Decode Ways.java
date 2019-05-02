class Solution {
    public int numDecodings(String s) {
        int pre = (int)(s.charAt(0) - '0'), cur = pre;
        int[] f = new int[s.length()];
        if(pre == 0){
            return 0;
        }
        f[0] = 1;
        for(int i = 1; i < s.length(); i++){
            cur = (int)(s.charAt(i) - '0');
            int isValue = pre * 10 + cur;
            if(isValue == 0 || (isValue > 26 && cur == 0)){
                return 0;
            }
            if(isValue > 26 || pre == 0){
                f[i] = f[i-1];
            }
            else if(cur == 0){
                f[i] = i > 1 ? f[i-2] : f[i-1];
            }
            else{
                f[i] = i == 1 ? 1 + f[i-1] : f[i-1] + f[i-2];
            }
            pre = cur;
        }
        return f[s.length() - 1];
    }
}
