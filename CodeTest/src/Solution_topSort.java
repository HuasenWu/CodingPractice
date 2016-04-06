import java.util.*;
public class Solution_topSort {
    public ArrayList<DirectedGraphNode> topSort_BFS(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> results = new ArrayList<DirectedGraphNode>();
        if (graph == null || graph.size() == 0) {
            return results;
        }
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                map.put(node, 0);
            }
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }
        Queue<DirectedGraphNode> myQ = new LinkedList<DirectedGraphNode>();
        for (Map.Entry<DirectedGraphNode, Integer> e : map.entrySet()) {
            if (e.getValue() == 0) {
                myQ.add(e.getKey());
            }
        }
        while (!myQ.isEmpty()) {
            DirectedGraphNode node = myQ.poll();
            results.add(node);
            for (DirectedGraphNode neighbor : node.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0) {
                    myQ.add(neighbor);
                }
            }
        }
        return results;
    }
    
    public ArrayList<DirectedGraphNode> topSort_DFS(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> results = new ArrayList<DirectedGraphNode>();
        if (graph == null || graph.size() == 0) {
            return results;
        }
        //HashMap<DirectedGraphNode, Boolean> map = new HashMap<DirectedGraphNode, Boolean>();
        //for (DirectedGraphNode node : graph) {
        //    if (!map.contains(node)) {
        //        map.put(node, false);
        //        for (DirectedGraphNode neighbor : graph) {
        //            map.put(neighbor, false);
        //        }
        //    }
        //}
        Stack<DirectedGraphNode> stack = new Stack<DirectedGraphNode>();
        for (DirectedGraphNode head : graph) {
            if (!results.contains(head)) {
                stack.push(head);
                while (!stack.isEmpty()) {
                    DirectedGraphNode node = stack.peek();
                    boolean isTheEnd = true;
                    for (DirectedGraphNode neighbor : node.neighbors) {
                        if (!results.contains(neighbor)) {
                            isTheEnd = false;
                            stack.push(neighbor);
                            break;
                        }
                    }
                    if (isTheEnd) {
                        results.add(stack.pop());
                    }
                }
            }
        }
        Collections.reverse(results);
        return results;
    }
}
