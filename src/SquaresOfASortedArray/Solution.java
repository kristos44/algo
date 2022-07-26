/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        int i = 0;
        int j = nums.length - 1;

        for (int k = nums.length - 1; k >= 0; k--) {
            if (nums[j] * nums[j] > nums[i] * nums[i]) {
                result[k] = nums[j] * nums[j];
                j--;
            } else {
                result[k] = nums[i] * nums[i];
                i++;
            }
        }

        return result;
    }
}