// Example 1:

// Input: words = ["i","love","leetcode","i","love","coding"], k = 2
// Output: ["i","love"]
// Explanation: "i" and "love" are the two most frequent words.
// Note that "i" comes before "love" due to a lower alphabetical order.


class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Word> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).freq++;
            } else {
                map.put(words[i], new Word(words[i]));
            }
        }

        List<String> list_str = new ArrayList<>(map.keySet());

        Collections.sort(list_str, (a1, a2) -> {
            if (map.get(a1).freq == map.get(a2).freq) {
                return map.get(a1).val.compareTo(map.get(a2).val);
            } else {
                return map.get(a2).freq - map.get(a1).freq;
            }
        });

        return list_str.subList(0, k);
    }

    class Word {
        String val;
        int freq;

        Word(String val) {
            this.val = val;
            this.freq = 1;
        }
    }
}
