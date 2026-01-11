class Trie{
    Map<Character,Trie> hmap;
    boolean end;
    int index;

    public Trie(){
        this.hmap = new HashMap<>();
        this.end = false;
        this.index = -1;
    }

    public void addWords(String word,int ind){
        Trie temp = this;
        for(char c : word.toCharArray()){
            if(!temp.hmap.containsKey(c)){
                temp.hmap.put(c,new Trie());
            }
            temp = temp.hmap.get(c);
        }

        temp.end = true;
        temp.index = ind;
        return;
    }
}

class Solution {

    Set<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        int i=0,j;
        Trie root = new Trie();
        res= new HashSet<>();
        for(String word : words){
            root.addWords(word,i);
            i++;
        }
         
         int m = board.length;
         int n = board[0].length;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                dfs(words,board,i,j,root);
            }
        }

        return new ArrayList<>(res);
    }

    public void dfs(String[] words,char[][] board,int row,int col,Trie root){

        
        if(root.end == true){
            res.add(words[root.index]);
        }

        Trie temp = root;

        if(row<0 || row>=board.length || col<0 || col>=board[0].length || !temp.hmap.containsKey(board[row][col]))
          return;
          
         Trie next = temp.hmap.get(board[row][col]);
         char ch = board[row][col]; 

         board[row][col] = '#';

         dfs(words,board,row,col+1,next);
         dfs(words,board,row,col-1,next);
         dfs(words,board,row+1,col,next);
         dfs(words,board,row-1,col,next);

         board[row][col] = ch;

         return;
         
    }
}