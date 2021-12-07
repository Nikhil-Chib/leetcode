class Solution {
    public boolean canJump(int[] nums) {
    boolean[] isLastReachable = new boolean[nums.length];
	isLastReachable[nums.length-1] = true;
	
	for(int i=nums.length-2; i>=0; i--) {
		for(int j=1; j<=nums[i]; j++) {
			if(i+j >= nums.length) {
				break;
			}
			
			if(i+j < nums.length && isLastReachable[i+j]) {
				isLastReachable[i] = true;
				break;
			}
		}
	}
	
	return isLastReachable[0];
}
}