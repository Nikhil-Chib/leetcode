class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
	Map<String, Map<String, Integer>> graph = new HashMap<>();
	
	for(List<String> ticket : tickets) {
		String from = ticket.get(0);
		String to = ticket.get(1);
		
		if(!graph.containsKey(from)) {
			graph.put(from, new HashMap<String, Integer>());
		}
		
		if(!graph.get(from).containsKey(to)) {
			graph.get(from).put(to,0);
		}
		graph.get(from).put(to, graph.get(from).get(to)+1);
	}
	
	List<String> itinerary = new ArrayList<>();
	dfs(graph, "JFK", itinerary);
	
	Collections.reverse(itinerary);
	return itinerary;
}

public void dfs(Map<String, Map<String, Integer>> graph, String toTicket,  List<String> itinerary) {
    
    Map<String,Integer> dests = graph.get(toTicket);
	
	if(dests != null) {
		List<String> sortedKeys = new ArrayList<>(dests.keySet());
		Collections.sort(sortedKeys);
		
		for(String nextStop: sortedKeys) {
			if(dests.get(nextStop) > 0) {
				dests.put(nextStop, dests.get(nextStop)-1);
				dfs(graph, nextStop, itinerary);
			}
			
		}
	}
	
	itinerary.add(toTicket);
}
}