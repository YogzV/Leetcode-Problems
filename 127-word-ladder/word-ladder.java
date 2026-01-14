class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        int level = 1;
        int len = beginWord.length();

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            // Always expand smaller side
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevel = new HashSet<>();

            for (String word : beginSet) {
                char[] arr = word.toCharArray();

                for (int i = 0; i < len; i++) {
                    char old = arr[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;

                        arr[i] = c;
                        String next = new String(arr);

                        if (endSet.contains(next)) {
                            return level + 1;
                        }

                        if (dict.remove(next)) {
                            nextLevel.add(next);
                        }
                    }
                    arr[i] = old;
                }
            }

            beginSet = nextLevel;
            level++;
        }

        return 0;
    }
}
