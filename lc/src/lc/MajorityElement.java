package lc;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int majorityElement(int[] num) {
        if(num.length == 0){
        	return 0;
        }
    	int major = 0;
    	int count = 0;
    	boolean hasmajor = false;
    	for(int i=0;i<num.length;i++){
    		if(hasmajor){
    			if(num[i] != major){
        			count --;
        			if(count == 0){
        				hasmajor = false;
        				major = 0;
        			}
        		} else {
        			count++;
        		}
    		} else {
    			major = num[i];
    			count = 1;
    			hasmajor = true;
    		}
    	}
    	return major;
    }
}
