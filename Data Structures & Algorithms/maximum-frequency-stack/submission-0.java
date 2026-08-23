class FreqStack {
    Map<Integer, Integer> map;
    Stack<Integer> stack;
    Stack<Integer> stack2;
    public FreqStack() {
        map = new HashMap<>();
        stack = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        stack.push(val);
    }

    public int pop() {
        Integer freq = 0;
        for (int key : map.keySet()) {
            freq = Math.max(freq, map.get(key));
        }
        int answer = 0;
        while (!stack.isEmpty()) {
            Integer poped = stack.pop();
            if (map.get(poped) == freq) {
                answer = poped;
                if (freq == 1) {
                    map.remove(poped);
                } else {
                    map.put(poped, freq - 1);
                }
                break;
            } else {
                stack2.push(poped);
            }
        }
        while(!stack2.isEmpty()){
          Integer poped = stack2.pop();
          stack.push(poped);
        }
        return answer;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */