class Solution {
    public int evalRPN(String[] tokens) {

       Stack<Integer> s=new Stack<>();
       for(int i=0;i<tokens.length;i++){
       if(IsOperator(tokens[i])){
       int num2=s.pop();
       int num1=s.pop();
       int res=Operation(tokens[i],num1,num2);
       s.push(res);
       }else{
        int num=Integer.parseInt(tokens[i]);
        s.push(num);
       }
       }
    return s.pop();
    }

    public static boolean IsOperator(String a){
       return a.equals("+") ||
           a.equals("-") ||
           a.equals("*") ||
           a.equals("/");
    }

    public static int Operation(String operator,int opr1,int opr2){
        if(operator.equals("+")){
        return opr1+opr2;
        }else if(operator.equals("-")){
        return opr1-opr2;
        }else if(operator.equals("*")){
         return opr1*opr2;
        }else{
        return opr1/opr2;
        }
    }
}