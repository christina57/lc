package lc;

public class LengthofLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int lengthOfLastWord(String s) {
    	String a = s.trim();
        int len =0;
        for(int i=a.length()-1;i>=0;i--){
        	if(a.charAt(i)==' '){
        		return len;
        	} else {
        		len++;
        	}
        }
        return len;
    }
}
