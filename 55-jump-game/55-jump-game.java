class Solution {
    public boolean canJump(int[] nums) {
        return jumpSteps(nums) != -1;
    }
    
    public int jumpSteps(int[] nums) {
        // if(nums.length == 1) return 0;
        
        int maxIndexReached = 0;
        int curr = 0;
        int nextMaxIndexReachable = 0;
        int step = 0;
        
        while(curr <= maxIndexReached) {
            if(maxIndexReached >= nums.length-1) break;
            
            nextMaxIndexReachable = Math.max(nextMaxIndexReachable, curr+nums[curr]);
            
            if(curr == maxIndexReached) {
                if(nextMaxIndexReachable == maxIndexReached) break;
                
                maxIndexReached = nextMaxIndexReachable;
                step++;
            }
            
            curr++;
        }
        
        if(maxIndexReached >= nums.length-1) return step;
        return -1;
    }
}