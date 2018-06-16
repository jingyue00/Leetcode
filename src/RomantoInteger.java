/**
 * Solution: Input is the String of Roman, output is the Integer result
 *      Sort from high bit to low bit, if the high bit is larger, then
 *      directly add Integer of the bit, if smaller,
 *      add value of arrayS[i]) - 2 * (arrayS[i - 1])
 *      Use match and case to get the Integer, don't forget break in which case.
 *      Important: default result value is Integer of array[0]
 *      loop start from 1 to s.length() and the reason to minus 2 * (arrayS[i - 1])
 *      is in the next loop (arrayS[i - 1]) will be add again.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RomantoInteger {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        char[] arrayS = s.toCharArray();
        int res = checkNumber(arrayS[0]);
        for (int i = 1; i < s.length(); i++) {
            if (checkNumber(arrayS[i - 1]) < checkNumber(arrayS[i])) {
                res += checkNumber(arrayS[i]) - 2 * checkNumber(arrayS[i - 1]);
            } else {
                res += checkNumber(arrayS[i]);
            }
        }
        return res;
    }

    public int checkNumber(char c) {
        int result;
        switch(c) {
            case 'I':
                result = 1;
                break;
            case 'V':
                result = 5;
                break;
            case 'X':
                result = 10;
                break;
            case 'L':
                result = 50;
                break;
            case 'C':
                result = 100;
                break;
            case 'D':
                result = 500;
                break;
            case 'M':
                result = 1000;
                break;
            default:
                throw new IllegalArgumentException();
        }
        return result;
    }

//    public static void main(String[] args) {
//        RomantoInteger ri = new RomantoInteger();
//        System.out.println(ri.romanToInt("MCMXCIV"));
//    }
}
