class Solution {
    public int uniquePaths(int m, int n) {
	int[][] noOfUniquePath = new int[m][n];
	
	for(int i=m-1; i >=0; i--) {
		for(int j=n-1; j>=0; j--) {
			if(i == m-1 || j == n-1) {
				noOfUniquePath[i][j] = 1;
				continue;
			}
			
			noOfUniquePath[i][j] = noOfUniquePath[i+1][j] + noOfUniquePath[i][j+1];
		}
	}

	return noOfUniquePath[0][0];
}
}