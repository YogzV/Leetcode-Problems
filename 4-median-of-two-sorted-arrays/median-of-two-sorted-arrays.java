class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length > nums2.length)
        {
           return findMedianSortedArrays(nums2,nums1);
        }
 
        double ans = 0.0;

        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = (len1 + len2);
        int half = (total+1) /2;

        int start = 0;
        int end = len1;
        int mid1,mid2;
        while(start <= end)
        {
            mid1 = (start+end)/2;
            mid2 = half - mid1 ;
            int Aleft = (mid1-1)>=0 ? nums1[mid1-1] : Integer.MIN_VALUE;
            int Aright = (mid1)<len1 ? nums1[mid1] : Integer.MAX_VALUE;
            int Bleft = (mid2-1)>=0 ? nums2[mid2-1] : Integer.MIN_VALUE;
            int Bright = (mid2)<len2 ? nums2[mid2] : Integer.MAX_VALUE;

            if(Aleft <= Bright && Bleft <= Aright){
                if((total & 1) == 1){
                    ans = (double)Math.max(Aleft,Bleft);
                }else{
                    ans = (Math.max(Aleft,Bleft) + Math.min(Aright,Bright)) / 2.0;
                }
                break;
            }else if(Aleft > Bright){
                end = mid1-1;
            }else{
                start = mid1+1;
            }

        }
        return ans;
    }
}