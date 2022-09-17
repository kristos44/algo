// https://leetcode.com/problems/unique-paths/
// so there needs to be m - 1 downs and n - 1 rights, and I need to find all the permutations (I guess:))
// I don't need to find all permutations, I just need to find how much of them exists and this can be found with
// s! / d! * r! -> found here https://home.ubalt.edu/ntsbarsh/business-stat/otherapplets/comcount.htm where the PEPPER example is 
// this was my idea ^^, probably it could work if some method to count on big numbers would be used
// Striver's idea is to do recuresive call with DP lets check it out :)
class Solution {
    public int uniquePaths(int m, int n) {
        // return prepareMemoAndCountRecur(m, n);
        // return countOptimal(m, n);
        return onceAgain(m, n);
    }

    private int prepareMemoAndCountRecur(int m, int n) {
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        
        return count(0, 0, m, n, memo);
    }
    
    private int onceAgain(int m, int n) {
        int r = m - 1; // number of right steps
        int d = n - 1; // number of down steps
        int s = r + d; // number of all steps
        int min = Math.min(r, d); // which number of steps is bigger? rights?
        int max = Math.max(r, d); // or downs?
        double res = 1.0;
        
        for (int i = 1; i <= min; i++) {
            res = res * (max + i) / i; 
        }
        
        return (int) res;
    }
    
    private int count(int i, int j, int m, int n, int[][] memo) {
        if (i == m - 1 && j == n - 1) return 1;
        if (i >= m || j >= n) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        else {
            memo[i][j] = count(i + 1, j, m, n, memo) + count(i, j + 1, m, n, memo);
            return memo[i][j];
        }
    }
    
    // this is optimal solution, it just counts number of permutations so it's something similar
    // to the one I was trying to intoduce :), but have issues 1. with big numbers 2. with casting double to int
    // solution for 1. divide each not those big numbers, for 2. use res = res * .. not res *= :)
    // read about 10 c 3 combinations, as this solution is based on that :)
    private int countOptimal(int m, int n) {
        int steps = m + n - 2;
        int rights = m - 1;
        double res = 1.0;
        
        for (int i = 1; i <= rights; i++) {
            res = res * (steps - rights + i) / i;
        }
        
        return (int) res;
    }
}
