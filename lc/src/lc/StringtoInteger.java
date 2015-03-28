package lc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringtoInteger {

	public static void main(String[] args) {
		StringtoInteger s = new StringtoInteger();
		System.out.println(s.atoi(" -00123 "));
	}
	public int atoi(String stri) {
		if(stri == null || stri.length()==0){
			return 0;
		}
		String str = stri.trim();
		boolean firstint = false;
		int ispostive = 0;
		int result = 0;
		
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)<='9' && str.charAt(i)>='0'){
				firstint = true;
				if(ispostive==0){
					ispostive = 1;
				}
				int cur = str.charAt(i)-'0';
        		if(ispostive==1 && result>(Integer.MAX_VALUE-cur)/10){
        			return Integer.MAX_VALUE;
        		} else if (ispostive==-1 && -result<(cur+Integer.MIN_VALUE)/10){
        			System.out.println(cur);
        			return Integer.MIN_VALUE;
        		} else {
        			result = result*10+cur;
        			System.out.println(result);
        		}
			} else {
				if(firstint){
					return ispostive*result;
				}
				
				if(ispostive==0 && str.charAt(i)=='-'){
					ispostive = -1;
				} else if (ispostive==0 && str.charAt(i)=='+'){
					ispostive = 1;
				} else {
					return 0;
				}
				
			}
		}
		return ispostive*result;
	}
	
    public int atoi2(String str) {
    	String postive = "";
    	boolean ispostive = true;
    	Pattern p = Pattern.compile("-(\\d+)");
    	Matcher m = p.matcher(str);
    	if(m.find()){
    		ispostive = false;
    		postive = m.group(1);
    	}
    	p = Pattern.compile("(\\d+)");
		m = p.matcher(str);
		if(m.find()){
			postive = m.group(1);
		}
		
    	if(postive.equals("")){
    		return 0;
    	}

        int result = postive.charAt(0)-'0';
        if(postive.length()>10){
        	return ispostive?Integer.MAX_VALUE:Integer.MIN_VALUE;
        } else {
        	for(int i=1;i<postive.length();i++){
        		int cur = postive.charAt(i)-'0';
        		if(ispostive && result*10+cur-Integer.MAX_VALUE>0){
        			return Integer.MAX_VALUE;
        		} else if (!ispostive && result*10+cur-Integer.MAX_VALUE-1>0){
        			return Integer.MIN_VALUE;
        		} else {
        			result = result*10+cur;
        		}
        	}
        }
        return ispostive?result:-result;
    }
}
