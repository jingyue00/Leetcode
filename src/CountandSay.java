/**
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * Solution: if input is n, need to count n - 1 times. Each time get the string and loop it
 *      from 0 to array.length. If it equal to cur character, count ++, else append
 *      count and character to the StringBuilder and reset the count and cur character
 *      Important: loop until array.length, but we only can count++ or reset count and
 *      character if j != array.length.
 * Time Complexity: O(m * n) ? Not sure
 * Space Complexity: O(n)
 */
public class CountandSay {
    public String countAndSay(int n) {
        String res = "1";
        if (n == 1) {
            return res;
        }

        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            char[] array = res.toCharArray();
            char cur = array[0];
            for (int j = 0; j <= array.length; j++) {
                if (j != array.length && array[j] == cur) {
                    count++;
                } else {
                    sb.append(count).append(cur);
                    if (j != array.length) {
                        cur = array[j];
                        count = 1;
                    }
                }
            }
            res = sb.toString();
        }
        return res;
    }
}
