package lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zzren on 9/20/2016.
 */
public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new LinkedList<Integer>();

        ArrayList<Integer>[] edgess = new ArrayList[n];

        for(int i=0;i<n;i++){
            edgess[i] = new ArrayList<Integer>();
        }
        for(int a=0;a<edges.length;a++){
            edgess[edges[a][0]].add(edges[a][1]);
            edgess[edges[a][1]].add(edges[a][0]);
        }

        int[] pre = new int[n];
        int end1 = findHeight(n, edgess, 0, pre)[1];
        int[] r2 = findHeight(n, edgess, end1, pre);
        int end2 = r2[1];
        int height = r2[0];

        int mid = end2;
        for(int i=0;i<height/2;i++){
            mid = pre[mid];
        }
        res.add(mid);

        if(height % 2 == 1){
            res.add(pre[mid]);
        }
        return res;
    }

    private int[] findHeight(int n, ArrayList<Integer>[] edgess, int root, int[] pre){
        int height = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[n];
        q.offer(root);
        visited[root] = true;
        int c = root;
        pre[root] = -1;

        while(!q.isEmpty()){
            height++;
            int size = q.size();
            for(int i=0;i<size;i++){
                c = q.poll();

                for(Integer in : edgess[c]){
                    if(!visited[in]){
                        q.offer(in);
                        visited[in] = true;
                        pre[in] = c;
                    }
                }
            }
        }
        return new int[]{height-1, c};
    }
}
