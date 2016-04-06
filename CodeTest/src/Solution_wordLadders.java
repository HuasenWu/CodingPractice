import java.util.*;
public class Solution_wordLadders {
	   public int ladderLength(String start, String end, Set<String> dict) {
	        // write your code here
	        if (dict == null || dict.size() == 0) {
	            return 0;
	        }
	        HashSet<String> hash = new HashSet<String>();
	        Queue<String> queue = new LinkedList<String>();
	        hash.add(start);
	        queue.offer(start);
	        int len = 1;
	        while (!queue.isEmpty()) {
	            len++;
	            int size = queue.size();
	            for (int i = 0; i < size; i++) {
	                String word = queue.poll();
	                for (String nextWord : dict) {
	                    if (isAdjacent(nextWord, word)) {
	                        if (!hash.contains(nextWord)) {
	                            queue.offer(nextWord);
	                            hash.add(nextWord);
	                        }
	                        if (nextWord.equals(end)) {
	                            return len;
	                        }
	                    }
	                }
	            }
	        }
	        return len;
	    }
       private HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
       private HashMap<String, Integer> distance = new HashMap<String, Integer>();
       public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here  
        List<List<String>> ladders = new ArrayList<List<String>>();
        if (dict == null || dict.size() == 0) {
            return ladders;
        }
        dict.add(start);
        dict.add(end);
        for (String word : dict) {
            if (!map.containsKey(word)) {
                //ArrayList<String> neighbors = new ArrayList<String>();
                ArrayList<String> neighbors = findNeighbors(dict, word);
                //for (String candidate : dict) {
                //    if (isAdjacent(word, candidate)) {
                //        neighbors.add(candidate);
                //    }
                //}
                map.put(word, neighbors);
            }
        }
        
        HashSet<String> hash = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        hash.add(start);
        queue.offer(start);
        distance.put(start, 0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : map.get(word)) {
                    if (!hash.contains(nextWord)) {
                        hash.add(nextWord);
                        queue.offer(nextWord);
                        distance.put(nextWord, distance.get(word) + 1);
                    } 
                }
            }
        }
        ArrayList<String> path = new ArrayList<String>();
        path.add(end);
        helper(ladders, path, dict, start);
        return ladders;
    }
    private void helper(List<List<String>> ladders, ArrayList<String> path,
        Set<String> dict, String start) {
        if (path.get(path.size() - 1).equals(start)) {
            ArrayList<String> ladder = new ArrayList<String>(path);
            Collections.reverse(ladder);
            ladders.add(ladder);
            return;
        }
            
        String word = path.get(path.size() - 1);
        for (String nextWord : map.get(word)) {
            if (!path.contains(nextWord) && 
                    distance.get(nextWord) + 1 == distance.get(word)) {
                path.add(nextWord);
                helper(ladders, path, dict, start);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isAdjacent(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return (count == 1);
    }
    private ArrayList<String> findNeighbors(Set<String> dict, String word) {
        ArrayList<String> neighbors = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != word.charAt(i)) {
                    String candidate = word.substring(0, i) + ch + word.substring(i + 1);
                    if (dict.contains(candidate)) {
                        neighbors.add(candidate);
                    }
                }
            }
        }
        return neighbors;
    }
}