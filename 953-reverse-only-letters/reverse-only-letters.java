class Solution {
    public String reverseOnlyLetters(String s) {
       int start = 0;
       char[] arr = s.toCharArray();
       int end = s.length()-1;
       while(start < end)
       {
         if(!Character.isAlphabetic(arr[start]))
          start++;
         else if(!Character.isAlphabetic(arr[end]))
          end--;
        else{
            char temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
            
        }
       
          
         
       } 
        return new String(arr);
    }
}