class Solution {
    public int uniquePaths(int m, int n) {
        int[][] strg = new int[m][n];
        
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(i == m-1 && j == n-1) {
                    strg[i][j] = 1;
                    continue;
                }
                
                int noOfWays = 0;
                if(i+1 < m) noOfWays += strg[i+1][j];
                if(j+1 < n) noOfWays += strg[i][j+1];
                
                strg[i][j] = noOfWays;
            }
        }
        
        return strg[0][0];
    }
}