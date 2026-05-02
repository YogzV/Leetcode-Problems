class Solution {
    public int rotatedDigits(int n) {
        Map<Character,Character> hmap = new HashMap<>();
        hmap.put('0','0');
        hmap.put('1','1');
        hmap.put('2','5');
        hmap.put('3','-');
        hmap.put('4','-');
        hmap.put('5','2');
        hmap.put('6','9');
        hmap.put('7','-');
        hmap.put('8','8');
        hmap.put('9','6');

        int ans = 0;
        int i,j;

        for(i=1;i<=n;i++){
           String str = Integer.toString(i);
           int len = str.length();
           StringBuilder temp = new StringBuilder();
           boolean fnd = true;
           for(j=0;j<len;j++){
             char ch = str.charAt(j);
             char rch = hmap.get(ch);
             if(rch == '-'){
                fnd = false;
                break;
             }
             temp.append(rch);
           }

           if(fnd && !temp.toString().equals(str))
            ans++;
        }
        return ans;
    }
}