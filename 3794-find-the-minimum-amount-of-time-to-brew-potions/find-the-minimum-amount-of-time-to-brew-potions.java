class Solution {
    public long minTime(int[] skill, int[] mana) {
        int slen = skill.length;
        int mlen = mana.length;
        long[] prevTime = new long[slen];
        int i,j;
        prevTime[0] = skill[0] * mana[0];
        for(i=1;i<slen;i++)
        {
            prevTime[i] = prevTime[i-1] + skill[i] * mana[0];
        }
 
      
        for(j=1;j<mlen;j++)
        {
            long delay = 0;
            long time = 0;
            for(i=0;i<slen;i++)
            {
                if(time >= prevTime[i])
                {
                    time = time + skill[i]*mana[j];
                }else{
                    delay = delay + (prevTime[i]-time);
                    time = time + (prevTime[i]-time) + skill[i] * mana[j];
                }
            }
            

            prevTime[0] = delay + mana[j]*skill[0];
            
            for(i=1;i<slen;i++)
              {
            
                prevTime[i] = prevTime[i-1] + skill[i] * mana[j];
                
              }
            
        }

        return prevTime[slen-1];
    }
}