class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] length = new int[text1.length()+1][text2.length()+1];
        for(int i=text1.length(); i>=0; i--) {
            for(int j=text2.length(); j>=0; j--) {
                if(i == text1.length() || j == text2.length()) {
                    continue;
                }
                
                if(text1.charAt(i) == text2.charAt(j)) {
                    length[i][j] = length[i+1][j+1] + 1;
                    continue;
                } else {
                    int fo = length[i][j+1];
                    int so = length[i+1][j];

                    length[i][j] = Math.max(fo, so);
                }
            }
        }
        return length[0][0];
    }
    
//     public int longestCommonSubsequence(String text1, String text2, int vi1, int vi2) {
//         if(vi1 == text1.length() || vi2 == text2.length()) {
//             return 0;
//         }
        
//         if(text1.charAt(vi1) == text2.charAt(vi2)) {
//             return longestCommonSubsequence(text1, text2, vi1+1, vi2+1) + 1;
//         } else {
//             int fo = longestCommonSubsequence(text1, text2, vi1, vi2+1);
//             int so = longestCommonSubsequence(text1, text2, vi1+1, vi2);
            
//             return Math.max(fo, so);
//         }
//     }
}