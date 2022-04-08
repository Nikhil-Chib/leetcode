class Solution {
    public String simplifyPath(String path) {
        String currPath = "";
        List<String> stack = new ArrayList<>();
        for(int i=0; i<path.length(); i++) {
            char cc = path.charAt(i);

            if(cc == '/') {
                updatePath(currPath, stack);
                currPath = "";
                continue;
            }

            currPath+= cc;
        }    
        
        updatePath(currPath, stack);
        
        if(stack.size() == 0) return "/";

        String canonicalPath = "";
        for(String p: stack) {
            canonicalPath += ("/"+p);
        }

        return canonicalPath;
    }

    public void updatePath(String path, List<String> stack) {
        if("".equalsIgnoreCase(path) || ".".equalsIgnoreCase(path)) {
            return;
        }

        if("..".equalsIgnoreCase(path)) {
            if(stack.size() > 0) stack.remove(stack.size()-1);
            return;
        }

        stack.add(path);
    }
}