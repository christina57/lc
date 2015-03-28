package lc;

import java.util.regex.Pattern;

public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isNumber("+."));
		System.out.println(isNumber(".1"));
		System.out.println(isNumber("abc"));
		System.out.println(isNumber("1 a"));
		System.out.println(isNumber("e10"));
		System.out.println(isNumber("+0.1"));
		System.out.println(isNumber("-2e10"));
		System.out.println(isNumber("-1.2e-10"));
	}
    public static boolean isNumber(String s) {
        if(Pattern.matches("\\s*[\\+|-]?\\d+\\s*", s)){
        	//System.out.println("a");
        	return true;
        }
        if(Pattern.matches("\\D*\\.\\D*", s)){
        	return false;
        }
        if(Pattern.matches("\\D*\\.\\D+\\d*\\D*", s)){
        	return false;
        }
        if(Pattern.matches("\\s*[\\+|-]?\\d*\\.\\d*\\s*", s)){
        	//System.out.println("b");
        	return true;
        }
        if(Pattern.matches("\\s*[\\+|-]?\\d+e[\\+|-]?\\d+\\s*", s)){
        	//System.out.println("c");
        	return true;
        }
        if(Pattern.matches("\\s*[\\+|-]?\\d*\\.\\d*e[\\+|-]?\\d+\\s*", s)){
        	//System.out.println("d");
        	return true;
        }
        return false;
    }
}
