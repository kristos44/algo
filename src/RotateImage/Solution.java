/**
* https://leetcode.com/problems/rotate-image/
* 1. Divide matrix into layers
* 2. Then move left layer to temp arr, down layer to left, right to down, top to right and finally top fill with valus from temp arr
* 3. Go one layer deeper and repeat procees
*/

class Solution {
    public void rotate(int[][] matrix) {
        int k = matrix[0].length - 1;
        for (int i = 0; i <= k / 2; i++) {
            int[] tempArr = new int[k - 2 * i];
            for (int j = 0; j < k - 2 * i; j++) {
                // left -> temp
                tempArr[j] = matrix[k - i - j][i];
                // down -> left
                matrix[k - i - j][i] = matrix[k - i][k - i - j];
                // right -> down
                matrix[k - i][k - i - j] = matrix[i + j][k - i];
                // top -> right
                matrix[i + j][k - i] = matrix[i][i + j];
                // temp -> top
                matrix[i][i + j] = tempArr[j];
            }
        }
    }
}
