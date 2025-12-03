class Solution {
    public int countTrapezoids(int[][] points) {
       Arrays.sort(points,Comparator.comparingInt(a -> a[1]));
       long Mod = 1000000007;
       int i,j;
       long res = 0;
       int size = points.length;
       long totalLines = 0;
       for(i=0;i<size;i=j)
       {
         j = i+1;
        while(j<size && points[i][1] == points[j][1]){
            j++;
        }
        long pts = j-i;
        long lines = (pts * (pts-1)) /2;
        res = (res + totalLines * lines) % Mod;
        totalLines = totalLines + lines;
        

       }
       return (int)res;

    }
}