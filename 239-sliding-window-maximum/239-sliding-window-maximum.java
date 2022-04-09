class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        int currIdx = 0;
        Deque<Integer> dq
            = new ArrayDeque<Integer>();
        
        for(int i=0; i<k-1; i++) {
            while(dq.size() > 0 && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            } 
            
            dq.addLast(i);
        }
        
        for(int i=k-1; i<nums.length; i++) {
            if(dq.size() > 0 && dq.peek() <= i-k) dq.poll();
            
            while(dq.size() > 0 && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            } 
            
            dq.addLast(i);
            ans[currIdx] = nums[dq.peek()];
            currIdx++;
            
        }
        
        return ans;
    }
}