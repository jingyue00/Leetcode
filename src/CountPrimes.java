/**
 * 204. Count Primes
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * 厄拉多塞筛法，求一组质数，时间复杂度仅有O(nloglogn)
 * 如果从1到n-1分别判断质数，时间复杂度为O(nsqrt(n))）
 * 1   2  3  4  5  6  7  8  9 10
 * 11 12 13 14 15 16 17 18 18 20
 *
 * Solution: use a boolean array. One multiplication factor x is from 2 to n
 *      another factor y start from 2 to x * y < n
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] noPrimes = new boolean[n];
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (noPrimes[i] == false) {
                ++res;
                for (int j = 2; i * j < n; j++) {
                    noPrimes[i * j] = true;
                }
            }
        }
        return res;
    }
}
