class Solution {
    public int jump(int[] nums) {
	nums[nums.length-1] = 0;
	for(int i=nums.length-2; i>=0; i--) {
		int maxJump = nums[i];
		int minStep = Integer.MAX_VALUE;
		for(int j=1; j<=maxJump; j++) {
			if(i+j >= nums.length) break;
			if(i+j != nums.length-1 && nums[i+j] == 0) continue;
			minStep = Math.min(minStep, nums[i+j]);
		}
		
		nums[i] = minStep == Integer.MAX_VALUE? 0 : minStep+1;
	}
	
	return nums[0];
}
}