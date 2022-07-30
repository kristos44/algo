class SolutionRec {
    private int[][] memo;
    
    public List<List<Integer>> generate(int numRows) {
        memo = new int[numRows][numRows];
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list;
        
        for (int i = 0; i < numRows; i++) {
            list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                list.add(count(i - j, j));
            }
            result.add(list);
        }
        
        return result;
    }
    
    private int count(int i, int j) {
        if (i == 0 || j == 0) return 1;
        
        if (memo[i][j] == 0) memo[i][j] = count(i - 1, j) + count(i, j - 1);
            
        return memo[i][j];
    }
}
