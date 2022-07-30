class Solution {
    private int[][] memo;
    
    public List<List<Integer>> generate(int numRows) {
        memo = new int[numRows][numRows];
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
