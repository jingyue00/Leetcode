/**
 * Requirement: directly reverse the order of string, hello -> olleh
 * Solution: Use while loop to swap the order.
 *      Important: transfer from char[] to String, need to use new String()
 *      Why does the toString() method in java not seem to work for an array?
 *      To get a human-readable toString(), you must use Arrays.toString(), like this:
 *      System.out.println(Arrays.toString(Array));
 *      Java's toString() for an array is to print [, followed by a character representing the type of the array's elements
 *      (in your case C for char), followed by @ then the "identity hash code" of the array
 *      (think of it like you would a "memory address").
 *      This sad state of affairs is generally considered as a "mistake" with java.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ReverseString {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] arrayS = s.toCharArray();
        int left = 0;
        int right = arrayS.length - 1;
        while (left < right) {
            char tmp = arrayS[left];
            arrayS[left++] = arrayS[right];
            arrayS[right--] = tmp;
        }
        return new String(arrayS);
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        System.out.println(rs.reverseString("hello"));
    }
}
