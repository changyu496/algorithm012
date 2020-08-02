package Week_04;

public class FindMinimumInRotatedSortedArray {

    /**
     * 153. 寻找旋转排序数组中的最小值
     * <p>
     * leetcode:https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        // 这种情况还是可以用二分的
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // 核心是这句话
            if (nums[mid] < nums[right]) {
                // mid 可能是最小值
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
        int index = findMinimumInRotatedSortedArray.findMin(new int[]{1, 2});
        System.out.println(index);
    }
}
