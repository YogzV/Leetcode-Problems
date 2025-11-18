class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i=0;
        int size = bits.length;
        while(i<size){
            if(i == size -1)
            {
             return true;
            }
            else if(bits[i] == 1){
                i++;
            }
            i++;
        }
        return false;
    }
}