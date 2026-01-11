class Trie{
    HashMap<Character,Trie> hmap;
    boolean end;
    public Trie(){
        this.hmap = new HashMap<>();
        this.end = false;
    }
}

class WordDictionary {

    Trie root;

    public WordDictionary() {
       this.root = new Trie();
        
    }
    
    public void addWord(String word) {

        Trie temp = root;
        for(char c : word.toCharArray()){
            if(!temp.hmap.containsKey(c)){
                temp.hmap.put(c,new Trie());
            }
            temp = temp.hmap.get(c);
        }
        temp.end = true;
        return;
    }
    
    public boolean search(String word) {
        Trie temp = root;
        return helper(word,0,temp);
    }

    public boolean helper(String word,int ind,Trie temp){
        
         int len = word.length();

         while(ind < len){
            if(word.charAt(ind) == '.'){
                
                for(Character c : temp.hmap.keySet()){
                    
                    Trie temp2 = temp.hmap.get(c);
                    if(temp2!=null && helper(word,ind+1,temp2)){
                        return true;
                    } 
                }
                return false;
               
            }else{
               if(!temp.hmap.containsKey(word.charAt(ind)))
                 return false;
               
               temp = temp.hmap.get(word.charAt(ind));
            }
            ind++;
        }

        return temp.end;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */