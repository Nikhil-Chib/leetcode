class Solution {
    public int findCircleNum(int[][] isConnected) {
	boolean[] isVisited = new boolean[isConnected.length];
	
	// DFS on graph to find the noOfDisconnected graph.
	int noOfProvince = 0;
	for(int i=0; i<isConnected.length; i++) {
		if(!isVisited[i]) {
			noOfProvince++;
			dfs(isConnected, i, isVisited);
		}
	}
	
	return noOfProvince;
}

public void dfs(int[][] isConnected, int curr, boolean[] isVisited) {
	if(isVisited[curr]) return;
	
	isVisited[curr] = true;
	for(int i=0; i<isConnected[curr].length; i++) {
		if(isConnected[curr][i] == 0) continue;
		
		dfs(isConnected, i, isVisited);
	}
}
}