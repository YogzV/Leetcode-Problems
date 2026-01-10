class Solution {
    Map<Character,String> hmap;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        hmap = new HashMap<>();
        hmap.put('2',"abc");
        hmap.put('3',"def");
        hmap.put('4',"ghi");
        hmap.put('5',"jkl");
        hmap.put('6',"mno");
        hmap.put('7',"pqrs");
        hmap.put('8',"tuv");
        hmap.put('9',"wxyz");
        
        StringBuilder str = new StringBuilder();
        backtrack(digits,0,str);
        return res;
    
    }

    public void backtrack(String digits,int ind,StringBuilder str){
        if(ind == digits.length()){
            
            res.add(str.toString());
            return;
        }
        
        String alpha = hmap.get(digits.charAt(ind));
        
        for(int i=0;i<alpha.length();i++){
            str.append(alpha.charAt(i));
            backtrack(digits,ind+1,str);
            str.deleteCharAt(str.length() -1);
        }
        return;
    }
}