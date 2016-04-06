import java.util.*;
public class Solution_topKFrequentWords {
	public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if (words == null || words.length == 0) {
            return null;
        }
        String[] result = new String[k];
        int[] countTopK = new int[k]; 
        ArrayList<String> uniqueWords = new ArrayList<String>();
        HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            if (!wordCounts.containsKey(words[i])) {
                uniqueWords.add(words[i]);
                wordCounts.put(words[i], 1);
            } else {
                wordCounts.put(words[i], wordCounts.get(words[i]) + 1);
            }
        }
        System.out.println(uniqueWords.size());
        for (int i = 0; i < uniqueWords.size(); i++) {
            String curWord = uniqueWords.get(i);
            int curCount = wordCounts.get(curWord);
            if (curCount > countTopK[k - 1] || 
            (curCount == countTopK[k - 1] && curWord.compareTo(result[k - 1]) < 0)) {
            	
                for (int j = 0; j < k; j++) {
                    if (curCount < countTopK[j] || 
                    (curCount == countTopK[j] && curWord.compareTo(result[j]) > 0)) {
                        continue;
                    } else {                    	
                        int tempCount = countTopK[j];
                        String tempStr = result[j];
                        countTopK[j] = curCount;
                        result[j] = curWord;
                        j++;
                        //System.out.println(result[j]);
                        while (j < k) {
                            int tempCount2 = countTopK[j];
                            String tempStr2 = result[j];
                            countTopK[j] = tempCount;
                            result[j] = tempStr;
                            tempCount = tempCount2;
                            tempStr = tempStr2;
                            j++;
                        } 
                    }
                }
            }
        }
        for (int j = 0; j < k; j++) {
        	System.out.println(result[j]);
        }
        return result;
    }
}
