class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int i;
        int prev = 0;
        for(i=0;i<len;i++)
        {
            if(i==len-1 || arr[i] == ' ')
            {
                int start = prev;
                int end = i-1;
                if(i==len-1)
                 end = i;
                while(start < end)
                {
                    char temp = arr[start];
                    arr[start++] = arr[end];
                    arr[end--] = temp;
                }
                prev = i+1;
            }
        }
        return new String(arr);
    }
}