class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hmap = new HashMap<>();
        int size = strs.length;
        for(int i=0;i<size;i++)
        {
            String str = strs[i];
            int[] freq = new int[26];
            for(char ch : str.toCharArray())
            {
                freq[ch-97]++;
            }
            String key = Arrays.toString(freq);
            if(hmap.containsKey(key))
            {
                hmap.get(key).add(str);
            }else{
                hmap.put(key,new ArrayList<>(Arrays.asList(str)));
            }
        }
        return new ArrayList<>(hmap.values());
    }
}