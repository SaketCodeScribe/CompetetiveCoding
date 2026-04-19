class MaxStack {
    static class Node{
        int data;
        Node next, prev;
        public Node(int x){
            data = x;
        }
    }
    Node head;
    TreeMap<Integer, Stack<Node>> map;
    public MaxStack() {
        map = new TreeMap<>();
    }


    private void insertInMap(Node node){
        map.computeIfAbsent(node.data, x -> new Stack<>()).push(node);
    }

    private void removeFromMap(int key){
        map.get(key).pop();
        if (map.get(key).isEmpty()) map.remove(key);
    }
    
    public void push(int x) {
        Node node = new Node(x);
        if (head != null){
            node.next = head;
            head.prev = node;
        }
        head = node;
        insertInMap(node);
    }
    
    public int pop() {
        int top = top();
        Node next = head.next;
        if (next != null){
            next.prev = head.next = null;
        }
        head = next;
        removeFromMap(top);
        return top;
    }
    
    public int top() {
        return head.data;
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        int key = peekMax();
        Node node = map.get(key).pop();
        if (map.get(key).isEmpty()) map.remove(key);
        Node next = node.next, prev = node.prev;
        if (prev != null && next != null){
            prev.next = next;
            next.prev = prev;
        }
        else if (prev == null && next == null){
            head = null;
        }
        else if (prev == null){
            next.prev = null;
            head = next;
        }
        else{
            prev.next = null;
        }
        node.next = node.prev = null;
        return key;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
