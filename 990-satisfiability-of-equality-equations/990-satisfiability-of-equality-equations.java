class Solution {
    private class Node {
        char ch;
        Node parent;
    }
    public boolean equationsPossible(String[] equations) {
        Map<Character, Node> map = new HashMap<>();
        
        for(String eq : equations) {
            char ch1 = eq.charAt(0);
            char ch2 = eq.charAt(3);
            char op = eq.charAt(1);
            
            if(op == '!') continue;
            
            
            if(!map.containsKey(ch1)) {
                Node node = new Node();
                node.ch = ch1;
                node.parent = node;
                map.put(ch1, node);
            }
            
            if(!map.containsKey(ch2)) {
                Node node = new Node();
                node.ch = ch2;
                node.parent = node;
                map.put(ch2, node);
            }
            
            Node rep1 = getRepChar(map.get(ch1));
            Node rep2 = getRepChar(map.get(ch2));
            
            if(rep1 != rep2)
                rep2.parent = rep1;
            
        }
        
        for(String eq : equations) {
            char ch1 = eq.charAt(0);
            char ch2 = eq.charAt(3);
            char op = eq.charAt(1);
            
            if(op == '=') continue;
            
            
            if(!map.containsKey(ch1)) {
                Node node = new Node();
                node.ch = ch1;
                node.parent = node;
                map.put(ch1, node);
            }
            
            if(!map.containsKey(ch2)) {
                Node node = new Node();
                node.ch = ch2;
                node.parent = node;
                map.put(ch2, node);
            }
            
            Node rep1 = getRepChar(map.get(ch1));
            Node rep2 = getRepChar(map.get(ch2));
            
            if(rep1 == rep2) return false;
            
        }
        
        return true;
    }
    
    public Node getRepChar(Node curr) {
        if(curr.parent == curr) return curr;
        
        Node parent = getRepChar(curr.parent);
        curr.parent = parent;
        
        return parent;
    }
}