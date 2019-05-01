class Solution {
    public double myPow(double x, int n) {
        long[] binary = new long[32];
        boolean flag = n < 0 ? false : true;
        double result = 1;
        long power = Math.abs((long)n);
        int i = 0;
        while(power != 0){
            binary[i++] = power % 2;
            power /= 2;
        }
        for(i = 0; i < 32; i++){
            if(binary[i] == 1){
                result *= x;
            }
            x *= x;
        }
        if(!flag){
            result = 1 / result;
        }
        return result;
    }
}
