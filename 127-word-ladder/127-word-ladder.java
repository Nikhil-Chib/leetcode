class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	
	Map<String, List<String>> graph = createGraphFromWordList(wordList);
        
    if(!graph.containsKey(endWord)) return 0;
        
    if(graph.containsKey(beginWord)) {
        int minLength = bfs(graph, beginWord, endWord);
        
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
        
        
	
	List<String> wordsAtSingleCharFromBegin = getWordsAtSingleCharChange(beginWord, wordList);
        
    
	
	int minLength = Integer.MAX_VALUE;
	for(String word: wordsAtSingleCharFromBegin) {
		int currLength = bfs(graph, word, endWord);
		minLength = Math.min(minLength, currLength);
	}
	
	return minLength == Integer.MAX_VALUE ? 0 : minLength+1;
}

public int bfs(Map<String, List<String>> graph, String word, String endWord) {
	if(word.equals(endWord)) return 1;
    Queue<String> queue = new LinkedList<>();
	queue.add(word);
	
	int currDist = 0;
	Map<String, Boolean> visited = new HashMap<>();
	
	while(!queue.isEmpty()) {
		int size = queue.size();
		currDist++; 
		
		while(size-- > 0) {
			String str = queue.remove();
			if(visited.containsKey(str)) continue;
			
			visited.put(str, true);
			for(String nbr: graph.get(str)) {
				if(endWord.equals(nbr)) return currDist+1;
				if(visited.containsKey(nbr)) continue;
				
				queue.add(nbr);
			}
		}
	}
	
	return Integer.MAX_VALUE;
}

public List<String> getWordsAtSingleCharChange(String beginWord, List<String> wordList) {
	List<String> words = new ArrayList<>();
	for(String word: wordList) {
		if(isSingleCharChange(beginWord, word)) words.add(word);
	}
	
	return words;
}

public Map<String, List<String>> createGraphFromWordList(List<String> wordList) {
	Map<String, List<String>> graph = new HashMap<>();
	
	for(int i=0; i<wordList.size(); i++) {
		String str1 = wordList.get(i);
		if(!graph.containsKey(str1)) graph.put(str1, new ArrayList<String>());
		
		for(int j=i+1; j<wordList.size(); j++) {
			String str2 = wordList.get(j);
			if(!graph.containsKey(str2)) graph.put(str2, new ArrayList<String>());
			
			if(!isSingleCharChange(str1,str2)) continue;
			
			graph.get(str1).add(str2);
			graph.get(str2).add(str1);
		}
	}	
	
	return graph;
}

public boolean isSingleCharChange(String str1, String str2) {
	if(str1.length() != str2.length()) return false;
	
	int noOfDifferentChar = 0;
	for(int i=0; i<str1.length() && i<str2.length(); i++) {
		if(str1.charAt(i) != str2.charAt(i)) noOfDifferentChar++;
	}
	
	return noOfDifferentChar == 1;
}
}