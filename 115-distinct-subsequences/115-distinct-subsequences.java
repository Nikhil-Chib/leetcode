class Solution {
    public int numDistinct(String s, String t) {
        int[][] strg = new int[s.length()+1][t.length()+1];
        
        for(int i=s.length(); i>=0; i--) {
            for(int j=t.length(); j>=0; j--) {
                if(j == t.length()) {
                    strg[i][j] = 1;
                    continue;
                }
                
                if(i == s.length()) {
                    strg[i][j] = 0;
                    continue;
                }
                
                int noOfSubsequences = strg[i+1][j];
                if(s.charAt(i) == t.charAt(j)) noOfSubsequences += strg[i+1][j+1];
                
                strg[i][j] = noOfSubsequences;
            }
        }
        
        return strg[0][0];
    }
}