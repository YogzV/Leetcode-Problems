class TrieNode{
    HashMap<Character,TrieNode> hmap;
    boolean end;
   public TrieNode(){
        this.hmap = new HashMap<>();
        this.end = false;
    }
}

class Trie {

    TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = root;
        for(char c : word.toCharArray()){
            if(!temp.hmap.containsKey(c)){
                temp.hmap.put(c,new TrieNode());
            }
            temp = temp.hmap.get(c);
        }
        temp.end = true;
        return;
    }
    
    public boolean search(String word) {
        TrieNode temp = root;
        for(char c : word.toCharArray()){
            if(!temp.hmap.containsKey(c))
              return false;
            
            temp = temp.hmap.get(c);
        }
        return temp.end;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(char c : prefix.toCharArray()){
            if(!temp.hmap.containsKey(c))
              return false;

            temp = temp.hmap.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */