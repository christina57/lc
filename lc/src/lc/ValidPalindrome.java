package lc;

public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindrome p = new ValidPalindrome();
		System.out.println(p.isPalindrome("1a2"));
	}
    public boolean isPalindrome(String s) {
        if(s==null || s.length()==0){
        	return true;
        }
        int left=0;
        int right = s.length()-1;
         
        while(left<right){
        	if(isNotAlpha(s.charAt(left))){
        		left++;
        		continue;
        	}
        	if(isNotAlpha(s.charAt(right))){
        		right--;
        		continue;
        	}
        	if(isEqualAlphaNocase(s.charAt(left), s.charAt(right))){
        		left++;
        		right--;
        	} else {
        		return false;
        	}
        }
        return true;
    }
    
    private boolean isNotAlpha(char a){
    	if((a<='z' && a>='a') || (a<='Z' && a>='A') || (a<='9' && a>='0')){
    		return false;
    	}
    	return true;
    }
    private boolean isEqualAlphaNocase(char a, char b){
    	if(a<='Z' && a>='A'){
    		a = (char)(a + 32);
    	}
    	
    	if(b<='Z' && b>='A'){
    		b = (char)(b + 32);
    	}
    	
    	if(a==b){
    		return true;
    	}
    	return false;
    }
}
