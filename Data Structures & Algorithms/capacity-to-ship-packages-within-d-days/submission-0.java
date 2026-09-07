class Solution {
    public int shipWithinDays(int[] weights, int days) {

    int l=-1;
    int r=0;

    for(int num:weights){
    l=Math.max(l,num);
    r+=num;
    }
    while(l<=r){
        int mid=l+(r-l)/2;
        if(check(weights,mid)>days){
            l=mid+1;
        }
        else{
            r=mid-1;
        }
        
    }
    return l;
        
    }
    public int check(int[] weights,int c){
     
     int days=1;
     long sum=0;

     for(int num:weights){
     if(sum+num<=c){
        sum+=num;
     }else{
        days++;
        sum=num;
     }
     }
     return days;

    }
}