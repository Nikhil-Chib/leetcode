class Solution {
    public boolean exist(char[][] board, String word) {
	boolean[][] visited = new boolean[board.length][board[0].length];
	
	for(int i=0; i<board.length; i++) {
		for(int j=0; j<board[0].length; j++) {
			if(board[i][j] != word.charAt(0)) {
				continue;
			}
            
			boolean ans = exist(board, word, i, j, 0, visited);
			if(ans) return true;
		}
	}
	
	return false;
}

public boolean exist(char[][] board, String word, int cx, int cy, int i, boolean[][] visited) {
    if(i == word.length()) {
		return true;
	}
    
	if(cx < 0 || cx >= board.length || cy < 0 || cy >= board[0].length || visited[cx][cy]) {
		return false;
	}
	
	
	if(board[cx][cy] != word.charAt(i)) {
		return false;
	}
	
	visited[cx][cy] = true;
	
	boolean ans = exist(board, word, cx-1, cy, i+1, visited);
	if(ans) return true;
	
	ans = exist(board, word, cx, cy-1, i+1, visited);
	if(ans) return true;
	
	ans = exist(board, word, cx+1, cy, i+1, visited);
	if(ans) return true;
	
	ans = exist(board, word, cx, cy+1, i+1, visited);
	if(ans) return true;
	
	visited[cx][cy] = false;
	
	return false;
}
}