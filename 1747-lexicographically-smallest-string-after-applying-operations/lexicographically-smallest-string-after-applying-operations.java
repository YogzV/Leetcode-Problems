class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        String ans = s ; 
        HashMap<String,Integer> hmap = new HashMap<>();
        hmap.put(s,1);
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        int rot = s.length() - b;
        int len = s.length();
        String str;
        while(!queue.isEmpty())
        {
           
              str = queue.poll();
             if(ans.compareTo(str) > 0)
             {
               ans = str;
             }
            
            StringBuilder added = new StringBuilder(str);
            for(int i = 1 ; i<len;i+=2)
            {
                int val = (str.charAt(i)-'0' + a) %10;
                char c = (char)(val+'0');

                added.setCharAt(i,c);
            } 
            
           String rotate = str.substring(rot,len) + str.substring(0,rot) ;
           
           if(!hmap.containsKey(added.toString()))
           {
            hmap.put(added.toString(),1);
            queue.offer(added.toString());
           }
           if(!hmap.containsKey(rotate))
           {
            hmap.put(rotate,1);
            queue.offer(rotate);
           }

        }
        
        return ans;
    }
}