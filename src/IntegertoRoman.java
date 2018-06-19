/**
 * Solution: first build nums array and roman array to match each number and roman letters.
 *      Then use for loop to go through nums array from the biggest number to the smallest number.
 *      If input num larger then current number in array nums, then let num minus nums[i] and
 *      add the correspond roman letters to StringBuilder
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
public class IntegertoRoman {
    public String intToRoman(int num) {
        int[] nums = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
           while (num >= nums[i]) {
               sb.append(roman[i]);
               num = num - nums[i];
           }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntegertoRoman ir = new IntegertoRoman();
        System.out.println(ir.intToRoman(4));
        System.out.println(ir.intToRoman(58));
        System.out.println(ir.intToRoman(1994));
    }
}
