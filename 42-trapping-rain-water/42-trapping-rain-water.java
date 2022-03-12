class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        
        leftMax[0] = height[0];
        for(int i=1; i<height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        
        int rightMax = height[height.length-1];
        for(int i=height.length-1; i>=0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            leftMax[i] = Math.min(leftMax[i], rightMax);
        }
        
        int sum = 0;
        for(int i=0; i<height.length; i++) {
            sum+= leftMax[i] - height[i];
        }
        
        return sum;
    }
}