class Solution {
    public int mySqrt(int x) {

        int l=0;
        int r=x/2;

        if(x<=3){
        if(x==1||x==2||x==3) return 1;
        else return 0;
        }


        while(l<=r){
          int  mid = l+(r-l)/2;

            if(mid==x/mid){
                return mid;
            }else if(mid<x/mid){
                l=mid+1;
            }else{
              r=mid-1;
            }
        }
        return r;
        
    }
}