//位运算 2的倍数的2进制只有最左一位为1，其余为0，而2的倍数减1
//的二进制全为1，例如8的二进制是1000，8-1=7的二进制为0111，故
//两者异或会等于0
class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }
}
