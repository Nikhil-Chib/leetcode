class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<numRows; i++) {
            if(i == 0) {
                ans.add(Arrays.asList(1));
                continue;
            }
            
            if(i == 1) {
                ans.add(Arrays.asList(1,1));
                continue;
            }
            
            List<Integer> currAns = new ArrayList<>();
            currAns.add(1);
            List<Integer> prevAns = ans.get(i-1);
            for(int j=0; j<prevAns.size()-1; j++) {
                currAns.add(prevAns.get(j) + prevAns.get(j+1));
            } 
            currAns.add(1);
            
            ans.add(currAns);
        }
        
        return ans;
    }
}