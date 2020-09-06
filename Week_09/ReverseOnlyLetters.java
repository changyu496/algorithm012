package Week_09;

/**
 * 917. 仅仅反转字母
 * <p>
 * https://leetcode-cn.com/problems/reverse-only-letters/
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] charArray = S.toCharArray();
        int i = 0;
        int j = charArray.length - 1;
        //  字符串"游戏"：每次都先找到符合条件的
        while (i < j) {
            while (!Character.isLetter(charArray[i]) && i < j) {
                i++;
            }
            while (!Character.isLetter(charArray[j]) && i < j) {
                j--;
            }
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters();
        System.out.println(reverseOnlyLetters.reverseOnlyLetters("7_28]"));
    }
}
