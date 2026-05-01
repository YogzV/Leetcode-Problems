class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int len = moves.length();
        int lCnt = 0;
        int rCnt = 0;
        int dCnt = 0;
        int i;
        for(i=0;i<len;i++){
            if(moves.charAt(i) == 'L')
             lCnt++;
            else if(moves.charAt(i) == 'R')
             rCnt++;
            else
             dCnt++;
        }

        return Math.max(lCnt,rCnt) - Math.min(lCnt,rCnt) + dCnt;


    }
}