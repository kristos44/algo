/**
* https://leetcode.com/problems/merge-sorted-array/
* - iterate from back on both nums1 (starting from first not zero) and nums2
* - put numbers from the last pos of nums1 and decreate pointer on the array from which number was taken
* - stop when begging of nums2 reached
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ind1 = m - 1;
        int ind2 = n - 1;
        
        for (int i = m + n - 1; i >= 0; i--) {
            if (ind2 < 0) break;
            
            if (ind1 >= 0 && nums1[ind1] > nums2[ind2]) {
                nums1[i] = nums1[ind1];
                ind1--;
            } else {
                nums1[i] = nums2[ind2];
                ind2--;
            }
        }
    }
}
