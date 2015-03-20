package lc;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
        	return "";
        }
        int len = 0;
        for(int i=0;i<strs[0].length();i++){
        	char cur = strs[0].charAt(i);
        	for(int j=1;j<strs.length;j++){
        		if(strs[j].length()<=i || strs[j].charAt(i) != cur){
        			break;
        		}
        	}
        	len++;
        }
        return strs[0].substring(0, len);
    }
}
