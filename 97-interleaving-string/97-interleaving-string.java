class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        
        return isInterleaveDP(s1, s2, s3);
    }
    
    public boolean isInterleave(String s1, String s2, String s3, int curr1, int curr2) {
        if(curr1 == s1.length() && curr2 == s2.length()) return true;
        
        int curr3 = curr1+curr2;
        if(curr1 == s1.length()) return s2.substring(curr2).equals(s3.substring(curr3));
        
        if(curr2 == s2.length()) return s1.substring(curr1).equals(s3.substring(curr3));
        
        if(s1.charAt(curr1) != s3.charAt(curr3) && s2.charAt(curr2) != s3.charAt(curr3)) {
            return false;
        }
        
        if(s1.charAt(curr1) == s2.charAt(curr2) && s1.charAt(curr1) == s3.charAt(curr3)) {
            return isInterleave(s1,s2,s3,curr1+1, curr2) || isInterleave(s1,s2,s3,curr1, curr2+1);
        }
        
        if(s1.charAt(curr1) == s3.charAt(curr3)) return isInterleave(s1,s2,s3,curr1+1, curr2);
        
        return isInterleave(s1,s2,s3,curr1, curr2+1);
    }
    
    public boolean isInterleaveDP(String s1, String s2, String s3) {
        boolean[][] strg = new boolean[s1.length()+1][s2.length()+1];
        
        for(int curr1=s1.length(); curr1>=0; curr1--) {
            for(int curr2=s2.length(); curr2>=0; curr2--) {
                if(curr1 == s1.length() && curr2 == s2.length()) {
                    strg[curr1][curr2] =  true;
                    continue;
                }

                int curr3 = curr1+curr2;
                if(curr1 == s1.length()) {
                    strg[curr1][curr2] = s2.substring(curr2).equals(s3.substring(curr3));
                    continue;
                } 

                if(curr2 == s2.length())  {
                    strg[curr1][curr2] = s1.substring(curr1).equals(s3.substring(curr3));
                    continue;
                }

                if(s1.charAt(curr1) != s3.charAt(curr3) && s2.charAt(curr2) != s3.charAt(curr3)) {
                    strg[curr1][curr2] = false;
                    continue;
                }

                if(s1.charAt(curr1) == s2.charAt(curr2) && s1.charAt(curr1) == s3.charAt(curr3)) {
                    strg[curr1][curr2] = strg[curr1+1][curr2] || strg[curr1][curr2+1];
                    continue;
                }

                if(s1.charAt(curr1) == s3.charAt(curr3)) {
                    strg[curr1][curr2] = strg[curr1+1][curr2];
                    continue;
                }

                strg[curr1][curr2] = strg[curr1][curr2+1];
            }
        }
        
        return strg[0][0];
        
    }
}