class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] matchFound = new boolean[s.length()+1][p.length()+1];
        
        for(int i=s.length(); i>=0; i--) {
            for(int j=p.length(); j>=0; j--) {
                if(i==s.length() && j==p.length()) {
                    matchFound[i][j] = true;
                    continue;
                }
                
                if(j == p.length()) {
                    matchFound[i][j] = false;
                    continue;
                }
                
                if(i == s.length()) {
                    if(p.charAt(j) == '*') matchFound[i][j] = matchFound[i][j+1];
                    else matchFound[i][j] = false;
                    
                    continue;
                }
                
                if(p.charAt(j) == '*') {
                    matchFound[i][j] = matchFound[i+1][j] || matchFound[i][j+1];
                    continue;
                }
                
                if(p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
                    matchFound[i][j] = matchFound[i+1][j+1];
                    continue;
                }
                
                matchFound[i][j] = false;
            }
        }
        
        return matchFound[0][0];
    }
}