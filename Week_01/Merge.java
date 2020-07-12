package Week_01;

public class Merge {
  /**
   * 合并两个有序数组
   * 
   * leetcode:https://leetcode-cn.com/problems/merge-sorted-array/
   * 
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    // 双指针 开空间法
    // 相对也是比较好理解的方法，只要想清楚，数组拷贝的部分
    // 确定就是空间复杂度高
    int i = 0;
    int j = 0;
    int p = 0;
    int[] nums1_copy = new int[m];
    System.arraycopy(nums1, 0, nums1_copy, 0, m);
    while (i < m && j < n) {
      if (nums1_copy[i] < nums2[j]) {
        nums1[p++] = nums1[i];
        i++;
      } else {
        nums1[p++] = nums2[j];
        j++;
      }
    }
    // 拷贝剩下的内容
    if (i < m) {
      System.arraycopy(nums1_copy, i, nums1, i + j, m + n - i - j);
    } else {
      System.arraycopy(nums2, j, nums1, i + j, m + n - i - j);
    }
  }
}