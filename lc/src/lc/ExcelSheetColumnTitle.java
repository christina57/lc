package lc;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public String convertToTitle(int n) {
    	if(n==0){
    		return "NULL";
    	}
        StringBuilder sb = new StringBuilder();
        
    	int cur = n;
    	int remainder = 0;
    	while(cur>0){
    		cur--;
    		remainder = cur%26;
    		sb.append((char)(remainder +'A'));
    		cur = cur/26;
    	}
    	return sb.reverse().toString();
    }
}
