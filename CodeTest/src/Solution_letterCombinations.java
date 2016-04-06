import java.util.*;
public class Solution_letterCombinations {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    private ArrayList<Character> list;
    private int[][] ind;
    Solution_letterCombinations() {
        list = new ArrayList<Character>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i));
        }
        ind = new int[8][2];
        int start = 0;
        for (int i = 2; i <= 9; i++) {
            ind[i - 2][0] = start;
            if (i != 7 && i != 9) {
                ind[i - 2][1] = ind[i - 2][0] + 2;
            } else {
                ind[i - 2][1] = ind[i - 2][0] + 3;
            }
            start = ind[i - 2][1] + 1;
        }
    }
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        ArrayList<String> ans = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) > '9' || digits.charAt(i) < '0') {
                return ans;
            }
        }
        StringBuilder path = new StringBuilder();
        letterCombinations(digits, path, 0, ans);
        return ans;
    }
    private void letterCombinations(String digits, StringBuilder path, int pos, ArrayList<String> ans) {
        if (pos == digits.length()) {
            ans.add(new String(path));
            return;
        }
        if (digits.charAt(pos) >= '2' && digits.charAt(pos) <= '9') {
        	System.out.println((digits.charAt(pos) - '2'));
            int start = ind[(digits.charAt(pos) - '2')][0];
            int end = ind[(digits.charAt(pos) - '2')][1];
            for (int i = start; i <= end; i++) {
                path.append(list.get(i));
                letterCombinations(digits, path, pos + 1, ans);
                path.deleteCharAt(path.length() - 1);
            }
        } else {
            letterCombinations(digits, path, pos + 1, ans);
        }
    }
}