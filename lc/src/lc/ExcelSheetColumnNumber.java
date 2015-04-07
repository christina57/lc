package lc;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int titleToNumber(String s) {
        
    	int result = 0;
    	for(int i=0;i<s.length();i++){
    		int cur = s.charAt(i)-'A'+1;
    		result  = result *26 + cur;
    	}
    	return result;
    }
}
