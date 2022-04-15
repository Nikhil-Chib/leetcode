class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String token: tokens) {
            if(!"*".equals(token) && !"+".equals(token) && !"/".equals(token) && !"-".equals(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            
            int op2 = stack.pop();
            int op1 = stack.pop();
            int result = 0;
            
            if("*".equals(token)) {
                result = op1*op2;
            } else if("+".equals(token)) {
                result = op1+op2;
            } else if("-".equals(token)) {
                result = op1-op2;
            } else {
                result = op1/op2;
            }
            
            stack.push(result);
        }
        
        return stack.pop();
    }
}