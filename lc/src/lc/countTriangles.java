package lc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class countTriangles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		GraphNode n6 = new GraphNode(6);
		GraphNode n7 = new GraphNode(7);
		GraphNode n8 = new GraphNode(8);
		
		ArrayList<GraphNode> nb1 = new ArrayList<GraphNode>();
		nb1.add(n2);
		nb1.add(n3);
		n1.neighbors = nb1;
		
		ArrayList<GraphNode> nb2 = new ArrayList<GraphNode>();
		nb2.add(n1);
		nb2.add(n3);
		nb2.add(n4);
		nb2.add(n5);
		n2.neighbors = nb2;
		
		ArrayList<GraphNode> nb3 = new ArrayList<GraphNode>();
		nb3.add(n1);
		nb3.add(n2);
		nb3.add(n6);
		//nb3.add(n5);
		n3.neighbors = nb3;
		
		ArrayList<GraphNode> nb4 = new ArrayList<GraphNode>();
		nb4.add(n2);
		n4.neighbors = nb4;
		
		ArrayList<GraphNode> nb5 = new ArrayList<GraphNode>();
		nb5.add(n2);
		nb5.add(n6);
		nb5.add(n7);
		nb5.add(n8);
		//nb5.add(n3);
		n5.neighbors = nb5;
		
		ArrayList<GraphNode> nb6 = new ArrayList<GraphNode>();
		nb6.add(n3);
		nb6.add(n5);
		nb6.add(n8);
		n6.neighbors = nb6;
		
		ArrayList<GraphNode> nb7 = new ArrayList<GraphNode>();
		nb7.add(n5);
		nb7.add(n8);
		n7.neighbors = nb6;
				
		ArrayList<GraphNode> nb8 = new ArrayList<GraphNode>();
		nb8.add(n5);
		nb8.add(n6);
		nb8.add(n7);
		n8.neighbors = nb8;
		
		countTriangles q = new countTriangles(); 		
		System.out.println(q.countTriangle(n1));
		
		/*
		 * 			 1
		 * 			/ \	
		 * 		   2 - 3
		 * 		  / \   \
		 * 		 4	 5 - 6
		 * 			/ \ /
		 * 		   7 - 8	
		 */
	}
	public int countTriangle(GraphNode node) {
		int result = 0;
		HashSet<GraphNode> used = new HashSet<GraphNode>();
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		queue.offer(node);
		
		while(!queue.isEmpty()){
			GraphNode cur = queue.poll();
			if(!used.contains(cur)){
				used.add(cur);
				ArrayList<GraphNode> neighbors = cur.neighbors;
				int count = neighbors.size();
				System.out.println("cur"+cur.label+","+count);
				
				for(int i=0;i<count;i++){
					if(!used.contains(neighbors.get(i))){
						queue.offer(neighbors.get(i));
						for(int j=i+1;j<count;j++){
							if(!used.contains(neighbors.get(j)) && neighbors.get(i).neighbors.contains(neighbors.get(j))){
								result++;
							}
						}
					}
				}
			}
		}
		return result;
	}
}

class GraphNode {
	int label;
	ArrayList<GraphNode> neighbors;

	GraphNode(int x) {
		label = x;
		neighbors = new ArrayList<GraphNode>();
	}
}
