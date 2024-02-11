import java.util.*;

class Contest384Solution3 {
    public int maxPalindromesAfterOperations(String[] words) {
        Map<Character, Integer> charFreq = new HashMap<>();
        List<Integer> halfPairs = new ArrayList<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
            }
            halfPairs.add(word.length() / 2);
        }

        int totalHalfPairs = 0;
        for (int freq : charFreq.values()) {
            totalHalfPairs += freq / 2;
        }
        Collections.sort(halfPairs);
        int wordIndex = 0;
        for (int halfPair : halfPairs) {
            if ((totalHalfPairs -= halfPair) < 0) {
                return wordIndex;
            } else {
                wordIndex++;
            }
        }
        return halfPairs.size();
    }
}
