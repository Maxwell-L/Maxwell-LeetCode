class Solution {
    public int mySqrt(int x) {
        for(long i = 2; i <= x / 2; i++){
            if(i * i == x || x < (i+1)*(i+1)){
                return (int)i;
            }
        }
        return x == 0 ? 0 : 1;
    }
}
