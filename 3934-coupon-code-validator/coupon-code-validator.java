class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> category = Arrays.asList("electronics","grocery","pharmacy","restaurant");
        List<Integer> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int i,j;
        int size = code.length;
        String pattern = "^[a-zA-Z0-9_]+$";
  
        for(i=0;i<size;i++)
        {
            if(isActive[i] == true && category.contains(businessLine[i]) && code[i].matches(pattern))
            {
                list.add(i);
            }
        }
             int len = list.size();
       

   
        for(i=0;i<len;i++)
        {
            for(j=i+1;j<len;j++)
            {
                int iInd = category.indexOf(businessLine[list.get(i)]);
                int jInd = category.indexOf(businessLine[list.get(j)]);
                if(jInd < iInd)
                {
                   int temp = list.get(i);
                   list.set(i,list.get(j));
                   list.set(j,temp);
                }
            }
        }
         for(i=0;i<len;i++)
         {
            
            for(j=i+1;j<len;j++)
            {
                if(businessLine[list.get(i)].equals(businessLine[list.get(j)])){
                    
                    if(code[list.get(i)].compareTo(code[list.get(j)]) >  0 )
                     {
                        int temp = list.get(i);
                        list.set(i,list.get(j));
                        list.set(j,temp);
                     }
                }
            }
         }
         for(i=0;i<len;i++)
         {
            res.add(code[list.get(i)]);
         }

        return res;
    }
}