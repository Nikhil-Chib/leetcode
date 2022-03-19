class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1) return 0;
        
        int[][] strg = new int[m][n];
        
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(i == m-1 && j == n-1) {
                    strg[i][j] = 1;
                    continue;
                }
                
                int noOfWays = 0;
                if(i+1 < m && obstacleGrid[i+1][j] == 0) noOfWays += strg[i+1][j];
                if(j+1 < n && obstacleGrid[i][j+1] == 0) noOfWays += strg[i][j+1];
                
                strg[i][j] = noOfWays;
            }
        }
        
        return strg[0][0];
    }
}