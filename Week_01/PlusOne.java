package Week_01;

public class PlusOne {
  public int[] plusOne(int[] digits) {
    // 最直接的方法，是把这个数组转换为数字，然后+1，然后再转换为数组
    // 但实际这条路是很难走的，无论是int还是long，都有最大的取值范围
    int len = digits.length;
    for (int i = len - 1; i >= 0; i--) {
      digits[i]++;
      digits[i] %= 10;
      if (digits[i] != 0) {
        return digits;
      }
    }
    digits = new int[len + 1];
    digits[0] = 1;
    return digits;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 9 };
    PlusOne plusOne = new PlusOne();
    plusOne.plusOne(nums);
  }
}