class Pair{
    String str;
    int seq;
    Pair(String str,int seq){
        this.str = str;
        this.seq = seq;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        Set<String> vis = new HashSet<>();
        int len = beginWord.length();
        int ans = Integer.MAX_VALUE;
        int i,j;
        Pair pair;
        int seq;
        String str,tempStr;
        StringBuilder temp;

        for(String s : wordList){
            set.add(s);
        }

        if(!set.contains(endWord))
          return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord,1));
        vis.add(beginWord);

        while(!queue.isEmpty()){
            
            pair = queue.poll();
            str = pair.str;
           
            seq = pair.seq;
            

            for(i=0;i<len;i++){

                temp = new StringBuilder(str);
                
                    for(j = 'a';j<='z';j++){

                        temp.setCharAt(i,(char)j);
                        tempStr = temp.toString();
                        if(tempStr.equals(endWord)){
                            ans = Math.min(ans,seq+1);
                        }
                        if(!vis.contains(tempStr) && set.contains(temp.toString())){
                            vis.add(tempStr);
                            queue.offer(new Pair(temp.toString(),seq+1));
                        }
                        
                    }
            }
        }

        return ans==Integer.MAX_VALUE? 0 : ans;
    }
}