package Week_01;

public class RemoveDuplicates {
  /**
   * 删除排序数组中的重复项 leetcode:
   * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
   * 
   * @param nums
   * @return
   */
  public int removeDuplicates(int nums[]) {
    // 思路1 本题是要求原地，如果不包括这个条件的话，其实可以新开一个空间，保存出现的元素，如果重复了就跳过
    // 思路2 用一个标志位，记录当前是个不重复的索引值，前提是因为当前是排序数组，如果有重复，也一定是这个索引的后面，如果是的话，就跳过，继续
    // 思路3 双指针法
    int slow = 0;
    for (int fast = 1; fast < nums.length; fast++) {
      if (nums[fast] != nums[slow]) {
        slow++;
        nums[slow] = nums[fast];
      }
    }
    return slow + 1;
  }
}