class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return canFinish(numCourses, prerequisites);
    }
    
    public int[] canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // create a graph using the prerequisites
        for(int i=0; i<numCourses; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        for(int i=0; i<prerequisites.length; i++) {
            int ai = prerequisites[i][0];
            int bi = prerequisites[i][1];

            graph.get(ai).add(bi);
        }

        // run DFS and store the prev nodes visited to detect the back-edge or cycle
        int[] visited = new int[numCourses];
        
        List<Integer> ans = new ArrayList<Integer>();

        for(int i=0; i<numCourses; i++) {
            if(!dfs(graph, i, visited, ans)) return new int[0];
        }

        int[] answer = new int[numCourses];
        
        for(int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }

    public boolean dfs(Map<Integer, List<Integer>> graph, int curr, int[] visited, List<Integer> ans) {

        if(visited[curr] == 1) return false;

        if(visited[curr] == 2) return true;

        visited[curr] = 1;

        List<Integer> dependentCourses = graph.get(curr);
        for(int i=0; i<dependentCourses.size(); i++) {
            if(!dfs(graph, dependentCourses.get(i), visited, ans)) return false;
        }

        visited[curr] = 2;

        ans.add(curr);
        return true;
    }

}