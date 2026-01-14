class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;
        int len = beginWord.length();

        while (!queue.isEmpty()) {
            int size = queue.size(); // FIXED

            for (int k = 0; k < size; k++) {
                String word = queue.poll();

                char[] arr = word.toCharArray();

                for (int i = 0; i < len; i++) {
                    char original = arr[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;

                        arr[i] = c;
                        String next = new String(arr);

                        if (next.equals(endWord)) {
                            return level + 1;
                        }

                        if (set.contains(next)) {
                            set.remove(next);   // mark visited
                            queue.offer(next);
                        }
                    }
                    arr[i] = original; // restore
                }
            }
            level++;
        }

        return 0;
    }
}
