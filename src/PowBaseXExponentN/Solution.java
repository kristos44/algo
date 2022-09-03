/**
* https://leetcode.com/problems/powx-n/
* 1. Notice that for example 3 to power of 4 is 9 to power of 2
* 2. Iterate in while shortening power's exponent and lenghtening base
* 3. While iterating when exponent not dividing by two is met store current base in list
* 4. After while loop is completed multiply x by each element stored in list
*/
class Solution {
    public double myPow(double x, int n) {
        if (x == 1.0) return x;
        if (n == 0) return 1.0;
                
        List<Double> multi = new ArrayList<>();
        
        while (n > 1 || n < -1) {
            if (n % 2 == 1 || n % 2 == -1) {
                multi.add(x);     
            }
            x *= x;
            n /= 2;
        }
        
        for (int i = 0; i < multi.size(); i++) {
            x *= multi.get(i);
        }
        
        return n > 0 ? x : 1 / x;
    }
}
