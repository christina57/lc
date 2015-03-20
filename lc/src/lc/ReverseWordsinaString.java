package lc;

public class ReverseWordsinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("ab b"));
	}
	
    public static String reverseWords(String s) {
    	String s_trim = s.trim();
    	if(s.length()==0){
    		return "";
    	}
    	StringBuilder sb = new StringBuilder();
    	String[] tokens = s_trim.split("\\s+");
    	for(int i=tokens.length-1;i>=0;i--){
    		sb.append(tokens[i]+" ");
    	}
    	if(sb.charAt(sb.length()-1) == ' '){
    		sb.deleteCharAt(sb.length()-1);
    	}
    	return sb.toString();
    }
    
    public static String reverseWords2(String s) {
    	StringBuilder sb =  new StringBuilder(s.trim());
    	if(sb.length()==0){
    		return "";
    	}
    	reverseHelper(sb, 0, sb.length()-1);
    	int start=0;
    	for(int i=0;i<sb.length();i++){
    		if(i==(sb.length()-1)){
    			if(i>start){
    				reverseHelper(sb, start, i);
    			}
    		}
    		if(sb.charAt(i)==' '){
    			if(i-1>start){
    				reverseHelper(sb, start, i-1);
    			}
    			if(i-1>=0 && sb.charAt(i-1)==' '){
    				sb.deleteCharAt(i);
    				i--;
    			}
    			start = i+1;
    		}
    	}
    	return sb.toString();
    }
    
    private static void reverseHelper(StringBuilder sb, int begin, int end){
    	for(int i=begin;i<=(end+begin)/2;i++){
    		char temp = sb.charAt(i);
    		sb.setCharAt(i, sb.charAt(begin+end-i));
    		sb.setCharAt(begin+end-i, temp);
    	}
    }
}
