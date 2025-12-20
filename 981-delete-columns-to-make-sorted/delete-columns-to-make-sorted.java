class Solution {
    public int minDeletionSize(String[] strs) {
        int i,j;
        int size = strs.length;
        int len = strs[0].length();
        int ans = 0;
        for(i=0;i<len;i++)
        {
            int val = strs[0].charAt(i);
            for(j=1;j<size;j++)
            {
               int val2 = strs[j].charAt(i);
               if(val2 < val)
                {
                    ans++;
                    break;
                }
                val = val2;
            }
        }
        return ans;
    }
}