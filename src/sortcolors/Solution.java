/**
* kristos44's solution
* 1. iterate and count occurences of each "color"
* 2. iterate and set each color that many times as it was previously counted
*/

class Solution {
    public void sortColors(int[] nums) {
        solve(3, nums);        
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
}
