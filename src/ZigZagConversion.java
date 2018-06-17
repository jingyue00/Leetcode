/**
 * Requirement: ZigZag convert a string, such as s = "PAYPALISHIRING", numRows = 3 -> "PAHNAPLSIIGYIR"
 * Solution: Use a StringBuilder[] to save the characters in each row. It's important to find that
 *      the length of a group of vertically down and obliquely up equals 2 * numRows - 2.
 *      Use for loop and reminder to find the position of each character. If the position < numRows,
 *      directly mapping the character to StringBuilder[]. If the position >= numRows, we need to
 *      use 2 * numRows - 2 - position. Then add this character into StringBuilder[].
 *      Important: don't forget to init StringBuilder in the array at the beginning and add StringBuilder
 *      in StringBuilder[] from 1 to sb.length - 1 into sb[0] at the end, then we can output string in sb[0].
 * /*n=numRows
 * Δ=2n-2    1                           2n-1                         4n-3
 * Δ=        2                     2n-2  2n                    4n-4   4n-2
 * Δ=        3               2n-3        2n+1              4n-5       .
 * Δ=        .           .               .               .            .
 * Δ=        .       n+2                 .           3n               .
 * Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
 * Δ=2n-2    n                           3n-2                         5n-4
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 1 || numRows <= 1) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        for (int i = 0; i < s.length(); i++) {
            int position = i % (2 * numRows - 2);
            int curPos = position < numRows ? position : 2 * numRows - 2 - position;
            sb[curPos].append(s.charAt(i));
        }
        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zzc = new ZigZagConversion();
        System.out.println(zzc.convert("PAYPALISHIRING", 4));
        System.out.println(zzc.convert("PA", 2));
    }
}
