class Solution {
    public boolean isValid(String s) {
        String[]sx=s.split("");
        Stack<String> st=new Stack<>();
        for(String x:sx){

            if(!st.isEmpty()){
             if(matcher(st.peek(),x)){
                st.pop();
             }else{
                st.push(x);
             }
            }else{
            st.push(x);
            }

        }

       return st.isEmpty(); 
    }

    public static boolean matcher(String s1, String s2) {
        switch (s1) {
            case "(":
                return s2.equals(")");
            case "{":
                return s2.equals("}");
            case "[":
                return s2.equals("]");
            default:
                return false;
        }
    }
}