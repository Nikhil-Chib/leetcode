class Solution {
    public int climbStairs(int n) {
        int np1 = 1;
        int np2 = 0;
        
        for(int i=n-1; i>=0; i--) {
            int currStep = np1+np2;
            np2 = np1;
            np1 = currStep;
        }
        
        return np1;
    }
}