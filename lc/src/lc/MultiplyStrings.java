package lc;

public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply("1","1000"));
	}
    public static String multiply(String num1, String num2) {
    	if(num1.equals("0") || num2.equals("0")){
    		return "0";
    	}
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        
        for(int i=0;i<(num1.length()+num2.length());i++){
        	int sum = carry;
        	for(int j=0;j<i+1;j++){
        		int idx1 = num1.length()-1-j;
        		int idx2 = num1.length()+num2.length()-2-i-idx1;
        		if(idx1>=0 && idx1<num1.length() && idx2>=0 && idx2<num2.length()){
        			sum += (num1.charAt(idx1)-'0') * (num2.charAt(idx2)-'0');
        		}
        	}
        	if(i == (num1.length()+num2.length()-1)){
        		if(sum == 0){
        			break;
        		}
        	}
        	carry = sum/10;
        	sb.append((char)(sum%10+'0'));
        }
        return sb.reverse().toString();
        
    }
}
