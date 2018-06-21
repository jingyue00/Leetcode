/**
 * Requirement: Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * Solution: According to Math, The essence of this problem is that 10^n ≡ 1 (mod 9),
 *      and thus a_n10^n + ... + a_110 + a_0 ≡ a_n + ... + a_1 + a_0 (mod 9).
 *      This process can be continued until a number less than 9 is gotten, i.e. num % 9.
 *      For any digit n, n = n % 9 unless n = 9. The only confusing case is n % 9 = 0,
 *      but addDigits(num) = 0 if and only if num = 0, otherwise it should be 9 in fact.
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class AddDigits {

    public static int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    public static int addDigits1(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum > 10) {
            return addDigits1(sum);
        } else {
            return sum;
        }
    }
}
