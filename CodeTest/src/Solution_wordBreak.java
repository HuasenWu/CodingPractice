import java.util.Set;
public class Solution_wordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return false;
		}
		if (dict.size() == 0) {
			return false;
		}
		int maxLen = 0; 
		for (String elem : dict) {
			if (maxLen < elem.length()) {
				maxLen = elem.length();
			}
		}
		int n = s.length();
		boolean[] f = new boolean[n + 1];
		for (int i = 0; i < n; i++) {
			f[i] = false;
		}
		if (dict.contains(String.valueOf(s.charAt(0)))) {
			f[0] = true;
		}
		for (int i = -1; i < n; i++) {
			System.out.println(i);
			for (int j = 1; j <= Math.min(maxLen,  n - 1 - i); j++) {
				System.out.println("I am in");
				char[] cand = new char[j];
				s.getChars(i + 1,  i + j + 1,  cand,  0);
				System.out.println(String.valueOf(cand));
				System.out.println(dict.contains(String.valueOf(cand)));
				if (i >= 0) {
					f[i + j] = f[i + j] || (f[i] && dict.contains(String.valueOf(cand)));
				} else {
					f[i + j] = f[i + j] || (dict.contains(String.valueOf(cand)));
				}
			}
		}
		return f[n - 1];
	}

}
