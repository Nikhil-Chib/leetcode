class Solution {
    public int minDistance(String text1, String text2) {
        int[][] length = new int[text1.length()+1][text2.length()+1];
        for(int i=text1.length(); i>=0; i--) {
            for(int j=text2.length(); j>=0; j--) {
                if(i == text1.length() && j == text2.length()) {
                    continue;
                }
                
                if(i==text1.length()) {
                    length[i][j] = text2.length()-j;
                    continue;
                }
                
                if(j==text2.length()) {
                    length[i][j] = text1.length()-i;
                    continue;
                }
                
                if(text1.charAt(i) == text2.charAt(j)) {
                    length[i][j] = length[i+1][j+1];
                    continue;
                } else {
                    int fo = length[i][j+1];
                    int so = length[i+1][j];

                    length[i][j] = Math.min(fo, so) + 1;
                }
            }
        }
        return length[0][0];
    }
    
    
}