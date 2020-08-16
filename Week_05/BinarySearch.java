package Week_05;

/**
 * 二分查找的模版
 */
public class BinarySearch {
    /**
     * 二分查找的三个条件
     * 1 单调递增
     * 2 有上下界限
     * 3 可以通过索引值直接访问
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3444};
        BinarySearch binarySearch = new BinarySearch();
        boolean ret = binarySearch.binarySearch(nums, 3444);
        System.out.println(ret);
    }
}
