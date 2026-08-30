class Solution {
    public int mySqrt(int x) {

        long l=0;
        long r=x/2;

        if(x<=3){
        if(x==1||x==2||x==3) return 1;
        else return 0;
        }


        while(l<=r){
           long  mid = l+(r-l)/2;

            if(mid*mid==x){
                return (int)mid;
            }else if(mid*mid<x){
                l=mid+1;
            }else{
              r=mid-1;
            }
        }
        return (int)r;
        
    }
}