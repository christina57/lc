package lc;

import java.util.LinkedList;
import java.util.List;

public class TextJustification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<String> fullJustify(String[] words, int L) {
    	List<String> result = new LinkedList<String>();
    	
        if(words==null || words.length==0){
        	return result;
        }
    	
        int idx =0;
        
        while(idx<words.length){
        	StringBuilder sb = new StringBuilder(words[idx]);
        	int cur_len = words[idx].length();
        	int count = 1;
        	while((idx+count)<words.length && (cur_len+words[idx+count].length()+1)<=L){
        		sb.append(" "+words[idx+count]);
        		cur_len += words[idx+count].length()+1;
        		count++;
        	}
        	
        	if(idx+count == words.length){
        		for(int i=0;i<(L-cur_len);i++){
        			sb.append(' ');
        		}
        		result.add(sb.toString());
        		return result;
        	}
        	if(count==1){
        		for(int i=0;i<(L-cur_len);i++){
        			sb.append(' ');
        		}
        	} else {
        		int whitespace_cnt = (L-cur_len)/(count-1);
        		int left_whitespace_cnt = (L-cur_len)%(count-1);
        		int fromidx = 0;
        		for(int i=0; i<left_whitespace_cnt; i++){
        			int whitespace_idx = sb.indexOf(" ", fromidx);
        			for(int j=0; j<=whitespace_cnt;j++){
        				sb.insert(whitespace_idx, ' ');
        			}
        			fromidx = whitespace_idx + whitespace_cnt + 2;
        		}
        		
        		for(int i=0; i<(count - left_whitespace_cnt - 1); i++){
        			int whitespace_idx = sb.indexOf(" ", fromidx);
        			for(int j=0; j<whitespace_cnt;j++){
        				sb.insert(whitespace_idx, ' ');
        			}
        			fromidx = whitespace_idx + whitespace_cnt + 1;
        		}	
        	}
        	result.add(sb.toString());
        	idx += count;
        }
        
        return result;
    }
}
