class Solution {

public String longestPalindrome(String s) {
	boolean[][] palindromes = new boolean[s.length()][s.length()];
	String maxString = s.substring(0,1);
    
    for(int i=0; i<s.length(); i++) {
        Arrays.fill(palindromes[i], true);
    }
    
	for(int k=1; k<s.length(); k++) {
		for(int i=0; i<s.length()-k; i++) {
			int j=i+k;
			if(s.charAt(i) == s.charAt(j)) {
				boolean ans = palindromes[i+1][j-1];
				if(ans && j-i+1 > maxString.length()) {
					maxString = s.substring(i,j+1);
				}
				
				palindromes[i][j] = ans;
                continue;
			}
			
			palindromes[i][j] = false;
		}
	}
	
	return maxString;
}

// public boolean longestPalindrome(String s, int i, int j) {
// 	if(i > j ) {
// 		return true;
// 	}
	
// 	if(s.charAt(i) == s.charAt(j)) {
// 		boolean ans = longestPalindrome(s, i+1, j-1);
// 		if(ans && j-i+1 > maxString.length()) {
// 			maxString = s.substring(i,j+1);
// 		}
		
// 		return ans;
// 	}
	
// 	longestPalindrome(s, i+1, j);
// 	longestPalindrome(s, i, j-1);
	
// 	return false;
	
// }
}