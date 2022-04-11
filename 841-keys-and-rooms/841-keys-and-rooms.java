class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        int count = 0;
        for(int i=0; i<rooms.size(); i++) {
            if(visited[i]) continue;
            count++;
            if(count > 1) return false;
            
            dfs(rooms, i, visited); 
        }
        
        return true;
    }
    
    public void dfs(List<List<Integer>> rooms, int currRoom, boolean[] visited) {
        if(visited[currRoom] ) return;
        
        visited[currRoom] = true;
        
        for(int i=0; i<rooms.get(currRoom).size(); i++) {
            dfs(rooms, rooms.get(currRoom).get(i), visited);
        }
    }
}