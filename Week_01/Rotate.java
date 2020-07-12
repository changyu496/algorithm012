package Week_01;

public class Rotate {
  /**
   * 旋转数组 leetcode:https://leetcode-cn.com/problems/rotate-array/
   * 
   * @param nums
   * @param k
   */
  public void rotate(int[] nums, int k) {
    // 思路1 不考虑空间复杂度，直接开一个新的空间，按照题意，先找到倒数第K个元素，依次挪到新的数组内，接着就再把剩下的元素放过去就好
    // 思路2 原地的话，直接想法就是得用一个额外的空间存一下前一个元素的，然后用来过度下，这个部分是我一直都思考不清楚的地方
    // 题目中还提到了多种解法，我现在是表示有点无奈，甚至一种解法都想不出来
    // 暴力法
    // 原地反转法，这是一个比较巧妙的思路，之前没有想到过，估计也是很容易被忘掉吧
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  public void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  /**
   * 暴力法，可以AC，但算法的时间复杂度很高，速度很慢 如果只旋转1次，那么其实就是把最后一位抽出来，然后把后面的元素都向后移动一位 然后就依次使用这个方法
   */
  public void rotateForce(int[] nums, int k) {
    int n = 0;
    while (n < k) {
      int prev = nums[nums.length - 1];
      for (int i = nums.length - 1; i > 0; i--) {
        nums[i] = nums[i - 1];
      }
      nums[0] = prev;
    }
    n++;
  }

  public static void main(String[] args) {
    Rotate rotate = new Rotate();
    int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
    printArray(nums);
    rotate.rotateForce(nums, 3);
    printArray(nums);
  }

  public static void printArray(int[] nums) {
    System.out.print("[");
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i]);
      if (i < nums.length - 1) {
        System.out.print(",");
      }
    }
    System.out.println("]");
  }
}