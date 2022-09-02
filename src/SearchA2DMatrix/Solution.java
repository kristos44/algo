/**
* kristos44 solution
* Solution base on two binary search
* 1. first using binary search we're looking for row which first element is smaller than target and which is right before the row which first element is bigger that target, if this condtino can't be met (target is bigger than first element in each row) we're taking last row
  2. then using classic binary search we're looking for the target in selected row, if found we return true else false
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int min = 0;
        int max = matrix.length - 1;
        int mid = max / 2;
        
        while (min <= max) {
            if (target >= matrix[mid][0]) {
                if (mid == matrix.length - 1 || target < matrix[mid + 1][0]) {
                    return binSearch(matrix[mid], target);
                } else {
                    min = mid + 1;
                    mid = (max - min) / 2 + min; 
                    continue;
                }
            }
            if (target < matrix[mid][0]) {
                max = mid - 1;
                mid = (max - min) / 2 + min; 
                continue;
            }                        
        }
                
        return false;
    }
    
    private boolean binSearch(int[] arr, int target) {
        int min = 0;
        int max = arr.length - 1;
        int mid = max / 2;
        while (min <= max) {
            if (target > arr[mid]) {
                min = mid + 1;
                mid = (max - min) / 2 + min; 
                continue;
            }
            if (target < arr[mid]) {
                max = mid - 1;
                mid = (max - min) / 2 + min; 
                continue;
            }
            return true;
        }
        return false;
    }
}
