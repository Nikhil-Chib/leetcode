/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Integer, Node> processed = new HashMap<>();
        
        return cloneGraph(node, processed);
    }
    
    public Node cloneGraph(Node node, Map<Integer, Node> processed) {
        if(processed.containsKey(node.val)) return processed.get(node.val);
        
        Node clonedNode = new Node(node.val);
        processed.put(node.val, clonedNode);
        
        for(Node nbr: node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(nbr, processed));
        }
        
        return clonedNode;
    }
}