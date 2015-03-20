package lc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadder2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadder2 q = new WordLadder2();
		String start = "nape"; 
		String end = "mild"; 
		HashSet<String> dict = new HashSet<String>();
		String[] dictStrs = {"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"};
		for (String str : dictStrs) {
			dict.add(str);
		}
		long startTime = System.currentTimeMillis();
		LinkedList<LinkedList<String>> result = q.findLadders(start, end, dict);
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println(elapsedTime);
	    
		for (LinkedList<String> item : result) {
			for (String str : item) {
				System.out.print(str + ",");
			}
			System.out.println("");
		}
	}

	public LinkedList<LinkedList<String>> findLadders(String start, String end, Set<String> dict) {
		//LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
        LinkedList<String> queue = new LinkedList<String>();
        HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
        HashMap<String,Integer> used = new HashMap<String,Integer>();
        int level =1;
        queue.offer(start);
        
        while(!queue.isEmpty()){
        	int cur_size = queue.size();
        	for(int i=0;i<cur_size;i++){
        		String cur = queue.poll();
        		//dict.remove(cur);
        		if(!used.containsKey(cur)){
        			used.put(cur, level);
            		
                	if(cur.equals(end)){
                		
                		LinkedList<LinkedList<String>> lists = new LinkedList<LinkedList<String>>();
                		LinkedList<String> list = new LinkedList<String>();
                		list.add(end);
                		lists.add(list);
                		return ConstructListRec(map, used, start, lists);
                	}
                	else{
                		Iterator<String> iterator = dict.iterator();
                		while(iterator.hasNext()){
                			String neighbor = iterator.next();
                			if(!used.containsKey(neighbor)){
                				if(hasOnlyOneChange(cur, neighbor)){
                					if(!map.containsKey(neighbor)){
                						LinkedList<String> prevs = new LinkedList<String>();
                						prevs.add(cur);
                						map.put(neighbor, prevs);
                					} else {
                						map.get(neighbor).add(cur);
                					}
                    				queue.offer(neighbor);
                    				//iterator.remove();
                    			}
                			}
            				
                		}
                	}
        		}
        		
            	//return result;
        	}
        	level++;
        }
        
        return null;
    }
	
	private LinkedList<LinkedList<String>> ConstructListRec(HashMap<String, LinkedList<String>> maps, HashMap<String,Integer> used, String start, LinkedList<LinkedList<String>> lists){
		LinkedList<LinkedList<String>> newlists = new LinkedList<LinkedList<String>>();
		//boolean markend=false;
		for(LinkedList<String> list: lists){
			String c = list.getFirst();
			if(c.equals(start)){
				//markend=true;
				//break;
				Iterator iterator = lists.iterator();
				while(iterator.hasNext()){
					LinkedList<String> next = (LinkedList<String>)iterator.next();
					String first = next.getFirst();
					if(!first.equals(start)){
						iterator.remove();
					}
				}
				
				return lists;
			} else{
				LinkedList<String> prevs = maps.get(c);
				for(String prev: prevs){
					if(used.get(prev)==(used.get(c)-1)){
						LinkedList<String> newlist = (LinkedList<String>)list.clone();
						newlist.addFirst(prev);
						newlists.add(newlist);
					}
				}
			}	
		}
		return ConstructListRec(maps, used, start, newlists);
	}
    
    private boolean hasOnlyOneChange(String s1, String s2){
    	int count=0;
    	for(int i=0;i<s1.length();i++){
    		if(s1.charAt(i) != s2.charAt(i)){
    			count++;
    			if(count>1){
    				return false;
    			}
    		}
    	}
    	return count==1;
    }
}
