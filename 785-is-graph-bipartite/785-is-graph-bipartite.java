class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        int[] group = new int[graph.length];
        Arrays.fill(group, -1);
        boolean[] visited = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(visited[i]) continue;
            queue.add(i);
            group[i] = 0;
            while(!queue.isEmpty()) {
                int curr = queue.poll();

                if(visited[curr]) continue;

                visited[curr] = true;
                int childGroup = (group[curr] == 0 ? 1:0);

                for(int child: graph[curr]) {
                    if(group[child] == -1) {
                        group[child] = childGroup;
                    } else if(group[child] != childGroup) return false;

                    if(!visited[child]) queue.add(child);
                }

            }
        }

        return true;
    }
}