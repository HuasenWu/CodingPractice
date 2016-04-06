import java.util.*;
public class Solution_NQueens {
    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> qArrays = new ArrayList<ArrayList<String>>();
        if (n == 0) {
            return qArrays;
        }
        ArrayList<Integer> qArray = new ArrayList<Integer>();
        helper(qArrays, qArray, n, 0);
        return qArrays;
    }
    private void helper(ArrayList<ArrayList<String>> qArrays, ArrayList<Integer> qArray, int n, int pos) { 
        if (qArray.size() == n) {
            ArrayList<String> qStrs = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j != qArray.get(i)) {
                        str.append('.');
                    } else {
                        str.append('Q');
                    }
                }
                qStrs.add(str.toString());
            }
            qArrays.add(qStrs);
            return;
        } 
        for (int i = 0; i < n; i++) {
            if (!conflict(qArray, i)) {
                qArray.add(i);
                helper(qArrays, qArray, n, pos + 1);
                qArray.remove(qArray.size() - 1);
            }
        }
        
    }
    private boolean conflict(ArrayList<Integer> qArray, int pos) {
        for (int j = 0; j < qArray.size(); j++) {
            if (qArray.get(j) == pos || Math.abs(qArray.get(j) - pos) == qArray.size() - j) {
                return true;
            }
        }
        return false;
    }    
}
