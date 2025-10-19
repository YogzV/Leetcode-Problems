class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        String ans = s;
        HashMap<String,Integer> hmap = new HashMap<>();
        hmap.put(s,1);
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        int rot = s.length() - b;
        while(!queue.isEmpty())
        {
           
            String str = queue.poll();
             if(ans.compareTo(str) > 0)
             {
               ans = str;
             }
            int len = str.length();
            StringBuilder added = new StringBuilder(str);
            for(int i = 1 ; i<len;i+=2)
            {
                added.setCharAt(i,(char) ((((str.charAt(i)-'0')+a) %10) + '0')) ;
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
        
        return ans;
    }
}