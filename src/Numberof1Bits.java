/**
 * Solution: Since an integer have 32 bits, each time check last bit, count ++ if equals 1
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Numberof1Bits {
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }

    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }
}
