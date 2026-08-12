// Two approch using Two stack or using below encoded way

class MinStack {
    int min;
    Stack<Long> s;

    public MinStack() {
        s=new Stack<>();

    }
    
    public void push(int value) {
       if(s.isEmpty()){
        min=value;
        s.push((long)value);
       }else{
        if(value>=min){
            s.push((long)value);
        }else{
            
            long encoded=((2*(long)value)-min);
            min=value;
            s.push(encoded);
        }

       }
       return;
    }
    
    public void pop() {
      if(s.peek()<min){
      int last_min=(int)((2*(long)min)-s.peek());
      min=last_min;
      s.pop();
     
      }else{
        s.pop();
      }
       return;  
    }
    
    public int top() {
    if(s.peek()<min){
      return min;
      }
      long top=s.peek();
       return (int)top;  
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */