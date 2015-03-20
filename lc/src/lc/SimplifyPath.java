package lc;

import java.util.LinkedList;

public class SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(simplifyPath("/"));
	}
    public static String simplifyPath(String path) {
        String[] tokens = path.split("/+");
        LinkedList<String> stack = new LinkedList<String>();
        
        for(String token: tokens){
        	if(token.equals("..")){
        		if(!stack.isEmpty()){
        			stack.pop();
        		}
        	} else if(!token.equals(".") && !token.equals("")){
        		stack.push(token);
        	}
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
        	sb.insert(0, "/"+stack.pop());
        }
        if(sb.length()==0){
        	sb.append("/");
        }
        return sb.toString();
    }
}
