package lc;

public class CountandSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(3));
	}
    public static String countAndSay(int n) {
        if(n==0){
        	return "";
        }
        if(n==1){
        	return "1";
        }
        StringBuffer sb = new StringBuffer();
        
        String last = countAndSay(n-1);
        char cur=last.charAt(0);
        int count=1;
        for(int i=1;i<last.length();i++){
        	if(last.charAt(i) == cur){
        		count++;
        	} else {
        		sb.append(count+""+cur);
        		cur = last.charAt(i);
        		count = 1;
        	}
        }
        sb.append(count+""+cur);
        return sb.toString();
    }
}
