package lc;

public class CompareVersionNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompareVersionNumbers q = new CompareVersionNumbers();
		System.out.println(q.compareVersion("1.1.1","1.1.1.000"));
	}
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int len = Math.min(s1.length, s2.length);
        
        for(int i=0;i<len;i++){
        	if(Integer.parseInt(s1[i]) > Integer.parseInt(s2[i])){
        		return 1;
        	} else if(Integer.parseInt(s1[i]) < Integer.parseInt(s2[i])){
        		return -1;
        	}
        }
        
        if(s1.length > s2.length){
        	for(int i=len;i<s1.length;i++){
        		if(Integer.parseInt(s1[i]) !=0){
        			return 1;
        		}
        	}
        	return 0;
        } else if(s1.length < s2.length){
        	for(int i=len;i<s2.length;i++){
        		if(Integer.parseInt(s2[i]) !=0){
        			return -1;
        		}
        	}
        	return 0;
        } else {
        	return 0;
        }
    }
}
