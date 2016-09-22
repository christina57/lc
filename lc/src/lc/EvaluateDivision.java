package lc;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by zzren on 9/21/2016.
 */
public class EvaluateDivision {

    public static void main(String[] args){
        String[][] equations = {{"a","b"},{"b","c"}};
        double[] values ={2.0, 3.0};
        String[][] queries = {{"a", "b"}};
        System.out.println((new EvaluateDivision()).calcEquation(equations, values, queries)[0]);
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        HashMap<String, HashMap<String, Double>> map = new HashMap<String, HashMap<String, Double>>();

        for(int i=0;i<values.length;i++){
            if(!map.containsKey(equations[i][0])){
                map.put(equations[i][0], new HashMap<String, Double>());
            }
            map.get(equations[i][0]).put(equations[i][1], values[i]);

            if(!map.containsKey(equations[i][1])){
                map.put(equations[i][1], new HashMap<String, Double>());
            }
            map.get(equations[i][1]).put(equations[i][0], 1.0/values[i]);
        }

        double[] result = new double[queries.length];

        for(int i=0;i<queries.length;i++){
            if(!map.containsKey(queries[i][0]) || !map.containsKey(queries[i][1])){
                result[i] = -1.0;
            } else if(queries[i][0].equals(queries[i][1])){
                result[i] = 1.0;
            } else {
                double[] res = new double[1];
                res[0] = 1.0;
                HashSet<String> visited = new HashSet<String>();
                boolean suc = dfs(queries[i][0], queries[i][1], res, map, visited);
                if(suc) {
                    result[i] = res[0];
                } else {
                    result[i] = -1.0;
                }
            }
        }

        return result;
    }

    private boolean dfs(String start, String end, double[] result, HashMap<String, HashMap<String, Double>> map, HashSet<String> visited){
        visited.add(start);
        HashMap<String, Double> cur = map.get(start);
        if(cur.containsKey(end)){
            result[0] *= cur.get(end);
            return true;
        } else {
            for(String next : cur.keySet()){
                if(visited.contains(next)){
                    continue;
                }
                result[0] *= cur.get(next);
                if(dfs(next, end, result, map, visited)){
                    return true;
                }
                result[0] /= cur.get(next);
            }
        }
        return false;
    }
}
