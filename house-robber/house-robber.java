class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1) {
            return nums[0];
        }
        int max = Math.max(nums[nums.length-1], nums[nums.length-2]);
        int[] currRob = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            currRob[i] = nums[i];
        }
        
        for(int i=nums.length-3; i>=0; i--) {
            int ans;
            if(i==nums.length-3) {
                ans = currRob[i+2];
            } else {
                ans = Math.max(currRob[i+2], currRob[i+3]);
            }
            currRob[i] += ans;
            
            max = Math.max(max, currRob[i]);
        }
        
        return max;
    }
}