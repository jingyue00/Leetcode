/**
 * Solution: use while loop and index to go through the array. Use the inner while loop
 *      to continue add number of count if they are same character. After the inner loop
 *      we can check the number of count, if count > 1, use String.valueOf() and toCharArray()
 *      to transfer count from integer to array of character and add the to chars array.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class StringCompression {
    public int compress(char[] chars) {
        int res = 0;
        int index = 0;
        while (index < chars.length) {
            char cur = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == cur) {
                index ++;
                count ++;
            }
            chars[res ++] = cur;
            if (count != 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[res ++] = c;
                }
            }
        }
        return res;
    }
}
