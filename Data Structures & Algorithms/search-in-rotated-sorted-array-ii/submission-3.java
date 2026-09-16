class Solution {

    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Target found
            if (nums[mid] == target) {
                return true;
            }

            /*
             * Cannot determine which half is sorted because
             * nums[low], nums[mid], and nums[high] are all equal.
             *
             * Example:
             * [1, 1, 1, 1, 1, 2, 1, 1, 1, 1]
             */
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            }

            // Left half is sorted
            else if (nums[low] <= nums[mid]) {
                /*
                 * Check whether target belongs in the sorted left half:
                 * [low ... mid]
                 */
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // Right half is sorted
            else {
                /*
                 * Check whether target belongs in the sorted right half:
                 * [mid ... high]
                 */
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}