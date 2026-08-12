class LRUCache {
    int capacity;
    HashMap<Integer, Node> map;
    Custom_Double_ll ll;

    public LRUCache(int capacity) {
      this.capacity=capacity;
      map = new HashMap<>();
      ll=new Custom_Double_ll(); 
      //dummy Node
      ll.push(-1,-1);
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        int ret=map.get(key).data;
            Node x=map.get(key);
            if(x.next!=null){
            x.prev.next=x.next;
            x.next.prev=x.prev;
            ll.Tail.next=x;
            x.prev=ll.Tail;
            x.next=null;
            ll.Tail=x;}

        return ret;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node x=map.get(key);
            
            if(x.next!=null){
            x.prev.next=x.next;
            x.next.prev=x.prev;
            ll.Tail.next=x;
            x.prev=ll.Tail;
            x.next=null;
            ll.Tail=x;
            }
            x.data=value;

        }
        else{
           if(map.size()<capacity){
            map.put(key,ll.push(value,key));
           }else{
            map.remove(ll.Head.next.key);
            if(ll.Head.next==ll.Tail){
                ll.Head.next=null;
                ll.Tail=ll.Head;
            }else{
            ll.Head.next=ll.Head.next.next;
            ll.Head.next.prev=ll.Head;
            }
            
           map.put(key,ll.push(value,key));
           }
        }
        return;
      }

}

class Node {
    Node next;
    Node prev;
    int data;
    int key;

    Node(int data, int key) {
        this.data = data;
        this.key = key;
    }
}

class Custom_Double_ll {
    Node Head;
    Node Tail;
    int size = 0;

    public Node push(int val, int key) {
        Node new_node = new Node(val, key);
        if (Head == null) {
            new_node.prev = null;
            new_node.next = null;
            Head = new_node;
            Tail = Head;
        } else {
            new_node.prev = Tail;
            new_node.next = null;
            Tail.next=new_node;
            Tail = new_node;
        }
        size++;
        return new_node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */