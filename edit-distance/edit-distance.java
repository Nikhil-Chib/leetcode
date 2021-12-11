class Solution {
    public int minDistance(String word1, String word2) {
        int[][] length = new int[word1.length()+1][word2.length()+1];
        
        for(int i=word1.length(); i>=0; i--) {
            for(int j=word2.length(); j>=0; j--) {
                if(i== word1.length() && j==word2.length()) {
                    length[i][j] = 0;
                    continue;
                }

                if(i == word1.length()) {
                    length[i][j] = word2.length()-j;
                    continue;
                }

                if(j == word2.length()) {
                    length[i][j] = word1.length()-i;
                    continue;
                }

                if(word1.charAt(i) == word2.charAt(j)) {
                    length[i][j] = length[i+1][j+1];
                    continue;
                }

                int fo = length[i][j+1];
                int so = length[i+1][j];
                int to = length[i+1][j+1];

                length[i][j] = Math.min(Math.min(fo, so), to) + 1;
                
                    }
                }
         return length[0][0];
    }
    
    public int minDistance(String word1, String word2, int i, int j) {
        if(i== word1.length() && j==word2.length()) {
            return 0;
        }
        
        if(i == word1.length()) {
            return word2.length()-j;
        }
        
        if(j == word2.length()) {
            return word1.length()-i;
        }
        
        if(word1.charAt(i) == word2.charAt(j)) {
            return minDistance(word1, word2, i+1, j+1);
        }
        
        int fo = minDistance(word1, word2, i, j+1);
        int so = minDistance(word1, word2, i+1, j);
        int to = minDistance(word1, word2, i+1, j+1);
        
        return Math.min(Math.min(fo, so), to) + 1;
    }
}