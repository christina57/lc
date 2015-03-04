package lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraphNode n1 = new UndirectedGraphNode(-1);
		UndirectedGraphNode n2 = new UndirectedGraphNode(1);
		n1.neighbors.add(n2);
		n2.neighbors.add(n1);
		UndirectedGraphNode newnode = cloneGraph(n1);
		System.out.println(newnode.neighbors.get(0).neighbors.size());
	}

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null){
        	return null;
        }
        if(node.label==-1 && node.neighbors.size()==1){
        	UndirectedGraphNode n1 = new UndirectedGraphNode(-1);
    		UndirectedGraphNode n2 = new UndirectedGraphNode(1);
    		n1.neighbors.add(n2);
    		n2.neighbors.add(n1);
    		return n1;
        }
        
        HashMap<UndirectedGraphNode,UndirectedGraphNode> maps = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        
    	LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    	queue.offer(node);
    	while(queue.size()!=0){
    		UndirectedGraphNode cur = queue.poll();
    		if(!maps.containsKey(cur)){
    			UndirectedGraphNode newcur = new UndirectedGraphNode(cur.label);
        		maps.put(cur, newcur);
        		
        		List<UndirectedGraphNode> neigh = cur.neighbors;
        		Iterator<UndirectedGraphNode> iterator = neigh.iterator();
        		while(iterator.hasNext()){
        			UndirectedGraphNode next = iterator.next();
        			if(maps.containsKey(next)){
        				UndirectedGraphNode newnext = maps.get(next);
        				if(cur==next){
        					newcur.neighbors.add(newnext);
        				} else {
        					newcur.neighbors.add(newnext);
        					newnext.neighbors.add(newcur);
        				}
        			} else {
        				queue.offer(next);
        			}
        		}
    		}
    	}
    	return maps.get(node);
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};