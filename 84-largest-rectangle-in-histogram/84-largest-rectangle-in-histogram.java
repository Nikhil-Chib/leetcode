class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        for(int i=0; i<heights.length; i++) {

            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int currHeight = heights[stack.pop()];
                int rightIndex = i-1;
                int leftIndex = (stack.isEmpty() ? -1 : stack.peek());
                int area = currHeight * (rightIndex - leftIndex);
                maxArea = Math.max(area, maxArea);
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int currHeight = heights[stack.pop()];
            int rightIndex = heights.length-1;
            int leftIndex = (stack.isEmpty() ? -1 : stack.peek());
            int area = currHeight * (rightIndex - leftIndex);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}