package lc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by zzren on 9/21/2016.
 */
public class ReconstructItinerary {

    public static void main(String[] args){
        String[][] tickets = {{"JFK", "SFO"},{"JFK","SJC"},{"SJC", "JFK"}};
        System.out.println((new ReconstructItinerary()).findItinerary(tickets));
    }

    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();

        for(int i=0;i<tickets.length;i++){
            if(!map.containsKey(tickets[i][0])){
                map.put(tickets[i][0], new PriorityQueue<String>());
            }
            map.get(tickets[i][0]).add(tickets[i][1]);
        }

        List<String> res = new LinkedList<String>();

        helper(map, res, "JFK");
        return res;
    }

    private void helper(HashMap<String, PriorityQueue<String>> map, List<String> res, String cur){

        while(map.containsKey(cur) && !map.get(cur).isEmpty()){
            helper(map, res, map.get(cur).poll());
        }
        res.add(0, cur);
    }
}
