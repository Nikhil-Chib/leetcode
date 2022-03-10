class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0) return 0;
        
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        int si = 0;
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch == ')') {
                if(stack.isEmpty()) {
                    si = i+1;
                    continue;
                }
                
                stack.pop();
                int currMaxLength = i-(stack.isEmpty() ? si-1 : stack.peek());
                maxLength = Math.max(maxLength, currMaxLength);
            } else {
                stack.push(i);
            }
        }
        
        return maxLength;
    }


}