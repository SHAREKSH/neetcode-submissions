class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

    Stack<Integer> s=new Stack<>();
    int[] op=new int[temperatures.length];
    for(int i=temperatures.length-1;i>=0;i--){

    while(!s.isEmpty()){
        if(temperatures[s.peek()]>temperatures[i] ){
           op[i]=s.peek();
           s.push(i);
           break;
        }else{
            s.pop();
        }
    }
        if(s.isEmpty()){
        op[i]=0;
        s.push(i);
        }

    }
        for(int j=0;j<op.length;j++){
        if(op[j]!=0){
            op[j]=op[j]-j;
        }
    }

    return op;
    }
}