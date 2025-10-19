class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        String ans = s ; 
        Set<String> vis = new HashSet<>();
        vis.add(s);
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
            for(b = 1 ; b<len;b+=2)
            {
                int val = (str.charAt(b)-'0' + a) %10;
                char c = (char)(val+'0');

                added.setCharAt(b,c);
            } 
            
           String rotate = str.substring(rot,len) + str.substring(0,rot) ;
           String add = added.toString();
           if(vis.add(add))
           {
           
            queue.offer(add);
           }
           if(vis.add(rotate))
           {
           
            queue.offer(rotate);
           }

        }
        
        return ans;
    }
}