class Solution {
    public int numDecodings(String s) {
        int[] strg = new int[s.length()+1];
        strg[s.length()] = 1;
        
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == '0') {
                strg[i] = 0;
                continue;
            }
            
            if(i == s.length()-1) {
                strg[i] = 1;
                continue;
            }
            
            int currNo = strg[i+1];
            if(twoDigitNumFormValidString(s, i)) currNo += strg[i+2];
            strg[i] = currNo;
        }
        
        return strg[0];
    }
    
    public boolean twoDigitNumFormValidString(String s, int i) {
        if(s.charAt(i) >= '3') return false;
        if(s.charAt(i) == '2' && s.charAt(i+1) > '6' ) return false;
        
        return true;
    }
}