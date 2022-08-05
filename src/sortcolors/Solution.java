/**
* https://leetcode.com/problems/sort-colors/
* kristos44's solution
* 1. iterate and count occurences of each "color"
* 2. iterate and set each color that many times as it was previously counted
*
* Striver's solution (Dutch flag algorithm)
* 1. keep three pointers min, mid, max
* 2. min points begining of arr, mid travers arr, max points end of arr
* 3. when mid traverse the array it swaps 0s with what is under min pointer and increase min pointer and mid pointer
*    and swaps 2s with what is under max pointer and decrease it, !!! no mid pointer change WHY?? !!!
*/

class Solution {
    public void sortColors(int[] nums) {
        // solve(3, nums);
        solveDutch(nums);
    }
    
    private void solve(int howManyColors, int[] nums) {
        int[] colors = new int[howManyColors];
        int numsLen = nums.length;
        
        for (int i = 0; i < numsLen; i++) {
            colors[nums[i]]++;
        }
        
        int j = 0;
        
        for (int i = 0; i < numsLen; i++) {
            while (colors[j] <= 0) {
                j++;
            }
            nums[i] = j;
            colors[j]--;        
        }
    }
    
    private void solveDutch(int[] nums) {
        int min = 0;
        int mid = 0;
        int max = nums.length - 1;
        
        while (mid <= max) {
            System.out.println(min + " " + mid + " " + max);
            switch (nums[mid]) {
                case 0:
                    swap(min++, mid++, nums);
                    break;
                    
                case 1:
                    mid++;
                    break;
                    
                case 2:
                    swap(mid, max--, nums);
                    break;
            }                
        }
    }
    
    private void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
