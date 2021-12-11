class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        
        int[][] ans = new int[amount+1][coins.length+1];
        
        for(int i=0; i<=amount; i++) {
            for(int j=coins.length; j>=0; j--) {
                if(i == 0) {
                    ans[i][j] = 0;
                    continue;
                }
                
                if(j == coins.length) {
                    ans[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                
                int fp = Integer.MAX_VALUE;
                if(i-coins[j] >= 0 && ans[i-coins[j]][j] != Integer.MAX_VALUE) {
                    fp = ans[i-coins[j]][j] + 1;
                }
                             
                int sp = ans[i][j+1];
                
                ans[i][j] = Math.min(fp, sp);
            }
        }
        
        return ans[amount][0] == Integer.MAX_VALUE ? -1 : ans[amount][0];
    }
    
    public int coinChange(int[] coins, int amount, int index) {
        if(amount == 0) {
            return 0;
        }
        
        if(amount < 0 || index >= coins.length) {
            return Integer.MAX_VALUE;
        }
        

        
        
        int fp = coinChange(coins, amount-coins[index], index);
        
        int sp = coinChange(coins, amount, index+1);
        
        return Math.min(fp == Integer.MAX_VALUE? fp : fp+1, sp);
    }
}