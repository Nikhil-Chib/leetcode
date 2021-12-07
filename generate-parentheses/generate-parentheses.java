class Solution {
    public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<>();
	LinkedList<Character> stack = new LinkedList<>();
	
	generateParenthesis(n, ans, stack, 0, "");
	return ans;
}

public void generateParenthesis(int n, List<String> ans, LinkedList<Character> stack, int noOfMatchedElements, String currAns) {
	
	if(stack.size() > n || noOfMatchedElements > stack.size()) {
		return;
	}
	
	
	if(noOfMatchedElements == n) {
		ans.add(currAns);
	}
	
	stack.addLast('(');
	generateParenthesis(n, ans, stack, noOfMatchedElements, currAns + "(");
	stack.removeLast();
	if(stack.size() == 0) {
		return;
	}
	
	generateParenthesis(n, ans, stack, noOfMatchedElements+1, currAns+")");
	
}
}