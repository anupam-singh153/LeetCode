class Solution {
    public String simplifyPath(String path) {
     
        Stack<String>stack = new Stack<>();
        
        for(String i : path.split("/")){
            
            // ignoreable String
            if(i.equals(".") || i.isEmpty())
            {
                continue;
            }
                
            // tends to previous directory
            else if(i.equals("..")){
                
                if(!stack.isEmpty())
                    stack.pop();
            }
                
            // valid file name
            else {
                stack.push(i);
            }
        }
            
        StringBuilder sb = new StringBuilder ();
        
        for(String i : stack){
        
            sb.append("/").append(i);
        }
            
        if(sb.length() == 0)
            sb.append("/");
            
        return sb.toString();
    }
}
