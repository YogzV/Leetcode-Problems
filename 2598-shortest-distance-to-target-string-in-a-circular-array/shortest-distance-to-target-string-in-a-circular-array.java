class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        if(words[startIndex].equals(target))
         return 0;
        int size = words.length;
        int ans = Integer.MAX_VALUE;
        int i = (startIndex+1)%size;
        int step = 1;
        while(i != startIndex){
           
            if(words[i].equals(target)){
                ans = step;
                break;
            }
            step++;
            i = (i+1)% size;
        }
          
        i = (startIndex - 1 +size)%size;
        step = 1;
        while(i != startIndex){
            if(words[i].equals(target)){
                ans = Math.min(ans,step);
                break;
            }
            step++;
            i = (i-1+size) % size;
        }

        return (ans == Integer.MAX_VALUE)? -1 : ans;
    }
}