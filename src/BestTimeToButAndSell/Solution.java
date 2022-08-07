/**
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
* 1. run big loop for buying date
* 2. run small loop to find out with which day after the buying day creates biggest profit
* 3. less brute force solution, runs internal loop only when finds smaller number than the one checked previously
* 4. even lesser brute force, beside keeping an eye on smallest element, we also store it's index and value of max and it's index,
*    we search for max in small loop only if max is zero or index of became bigger than index of max
*/

class Solution {
    public int maxProfit(int[] prices) {
        // return bruteForce(prices);
        // return lessBruteForce(prices);
        return evenLesserBruteForceButQuiteComplicated(prices);
    }
    
    private int bruteForce(int[] prices) {
        int pricesLen = prices.length;
        int pretender = 0;
        int champ = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < pricesLen - 1; i++) {
            for (int j = i + 1; j < pricesLen; j++) {
                pretender = prices[j] - prices[i];    
                if (pretender > champ) champ = pretender;
            }            
        }
        
        return champ;
    }
    
    private int lessBruteForce(int[] prices) {
        int pricesLen = prices.length;
        int pretender = 0;
        int champ = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < pricesLen - 1; i++) {
            if (prices[i] < min) {
                min = prices[i];
                for (int j = i + 1; j < pricesLen; j++) {
                    pretender = prices[j] - prices[i];    
                    if (pretender > champ) champ = pretender;
                }
            }
        }
        
        return champ;
    }
    
    private int evenLesserBruteForceButQuiteComplicated(int[] prices) {
        int pricesLen = prices.length;
        int pretender = 0;
        int champ = 0;
        int min = Integer.MAX_VALUE;
        int minInd = 0;
        int max = 0;
        int maxInd = 0;
        
        for (int i = 0; i < pricesLen - 1; i++) {
            if (prices[i] < min) {
                min = prices[i];
                minInd = i;
                if (max == 0 || minInd > maxInd) {
                    max = 0;
                    for (int j = i + 1; j < pricesLen; j++) {
                        if (prices[j] > max) {
                            max = prices[j];
                            maxInd = j;            
                        }
                    }
                }
                pretender = max - min;     
                
                if (pretender > champ) champ = pretender;
            }
        }
        
        return champ;
    }
}
