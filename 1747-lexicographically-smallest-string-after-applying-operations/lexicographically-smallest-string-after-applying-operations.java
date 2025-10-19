class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        StringBuilder ans = new StringBuilder(s); 
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
             if(ans.toString().compareTo(str) > 0)
             {
               ans = new StringBuilder(str);
             }
            
            StringBuilder added = new StringBuilder(str);
            for(int i = 1 ; i<len;i+=2)
            {
                int val = (str.charAt(i)-'0' + a) %10;
                char c = (char)(val+'0');

                added.setCharAt(i,c);
            } 
            StringBuilder rotate = new StringBuilder();
           rotate.append(str.substring(rot,len));
           rotate.append(str.substring(0,rot));
           
           if(!hmap.containsKey(added.toString()))
           {
            hmap.put(added.toString(),1);
            queue.offer(added.toString());
           }
           if(!hmap.containsKey(rotate.toString()))
           {
            hmap.put(rotate.toString(),1);
            queue.offer(rotate.toString());
           }

        }
        
        return ans.toString();
    }
}