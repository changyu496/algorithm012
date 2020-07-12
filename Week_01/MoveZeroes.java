package Week_01;

class MoveZeroes {
  public void moveZeroes(int[] nums) {
    // 这道题是视频的实战题目
    // 这类就选择用一个索引值记录最后一个不为0的位置，然后最后补0的方法
    int lastNonZeroIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[lastNonZeroIndex++] = nums[i];
      }
    }
    for (int i = lastNonZeroIndex; i < nums.length; i++) {
      nums[i] = 0;
    }
  }
}