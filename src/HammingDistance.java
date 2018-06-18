/**
 * Solution: to find hamming distance, use exclusive or to compare each bit of two integer
 *      then use bitCount() or for loop to find the number of difference (equals 1)
 *      Important: to count distance using for loop, since there are 32 bits, from 0 to 31,
 *      each time use >> move 1 position to the right and use & 1 to find whether it equals 0 or 1
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {

        return Integer.bitCount(x ^ y);

//        int xor = x ^ y, count = 0;
//        for (int i = 0; i < 32; i++)
//            count += (xor >> i) & 1;
//        return count;
    }

    public static void main(String[] args) {
        HammingDistance hd = new HammingDistance();
        System.out.println(hd.hammingDistance(1,4));
    }
}
