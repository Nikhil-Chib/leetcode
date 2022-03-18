class Solution {
    public int numTrees(int n) {
        int[] uniqueBSTs = new int[n+1];
        for(int i=1; i<=n; i++) {
            int sum = 0;
            for(int j=1; j<=i; j++) {
                int noOfNodesInLeft = j-1;
                int noOfNodesInRight = i-j;

                int currNoOfUniqueBSTs = 1;
                if(noOfNodesInLeft > 0) {
                    currNoOfUniqueBSTs *= uniqueBSTs[noOfNodesInLeft];
                }

                if(noOfNodesInRight > 0) {
                    currNoOfUniqueBSTs *= uniqueBSTs[noOfNodesInRight];
                }
                
                sum+=currNoOfUniqueBSTs;
            }
            
            uniqueBSTs[i] = sum;
        }
        
        return uniqueBSTs[n];
    }
}