/**
 * https://leetcode.com/problems/pascals-triangle/
 * 1. Iterate in double loop, outside loop is responsible for "lines" in triangle, inside loop for elements in line
 * 2. On each iteration of outside loop one more element is added in inside loop, so at the begining there was 1, then 2, etc.
 * 3. If element on border (condition j == 0 || j == i is true) of triangle set it to 1, else set as sum two other directly above it from previous line
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prev = null;
        List<Integer> curr;
        
        for (int i = 0; i < numRows; i++) {
            curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) curr.add(1);
                else curr.add(prev.get(j - 1) + prev.get(j));
            }
            prev = curr;
            result.add(curr);
        }
        
        return result;
    }
}
