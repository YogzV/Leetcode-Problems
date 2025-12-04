class Solution {
    public int countCollisions(String directions) {
        int right = 0;
        boolean found = false;
        int res = 0;
        for(char ch : directions.toCharArray())
        {
            if(ch =='R')
            {
                right++;
                found = true;
            }else if(ch == 'S')
            {
                res += right;
                right = 0;
                found = true;
            }else{
                if(found){
                res += right+1;
                right = 0;
                }

            }
        }
        return res;
    }
}