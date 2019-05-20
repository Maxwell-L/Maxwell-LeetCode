class Solution {
    private int fac(int n){
        int num = 1;
        while(n > 0){
            num *= n;
            n--;
        }
        return num;
    }
    public String getPermutation(int n, int k) {
        char[] result = new char[n];
        List<Character> arr = new ArrayList<Character>();
        for(int i = 1; i <= n; i++){
            arr.add((char)(i+'0'));
        }
        for(int i = 0, j = n-1; i < n; i++, j--){
            int temp = fac(j);
            int index = k <= temp ? 0 : (k - 1) / temp;
            result[i] = arr.get(index);
            arr.remove(index);
            k = k <= temp ? k : k - index * temp;
        }
        return String.valueOf(result);
    }
}
