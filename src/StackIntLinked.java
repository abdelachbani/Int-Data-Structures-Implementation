import java.util.NoSuchElementException;

public class StackIntLinked {
    private NodeInt top;  
    private int size;    

    /**
     * Creates an empty stack.
     */
    public StackIntLinked() {
        this.top = null;
        this.size = 0;
    }

    /**
     * Pushes x onto the stack. 
     * @param x int, the element to push.
     */
    public void push(int x) {
        this.top = new NodeInt(x, this.top);
        this.size++;
    }

    /**
     * Returns and removes the top element of the stack.
     * @throws NoSuchElementException if the stack is empty.
     * @return int, the top element of the stack.
     */
    public int pop() {
        if (this.top == null) {
            throw new NoSuchElementException("Empty stack");
        }
        int x = this.top.data;
        this.top = this.top.next;
        this.size--;
        return x;
    }

    /**
     * Returns the top element of the stack without removing it.
     * @throws NoSuchElementException if the stack is empty. 
     * @return int, the top element of the stack.
     */
    public int peek() { 
        if (this.top == null) { 
            throw new NoSuchElementException("Empty stack");
        }
        return this.top.data; 
    }

    /**
     * Checks if the stack is empty. 
     * @return boolean, true if and only if the stack is empty.
     */
    public boolean empty() { 
        return (this.top == null);  // or return (this.size == 0);
    }
    
    /**
     * Returns the number of elements in the stack.
     * @return int, the size.
     */
    public int size() { return this.size; } 
    
    /** 
     * Returns a String with the elements of the stack
     * from top to bottom.
     * If the stack is empty returns "".
     * @return String, the elements in the stack.
     */
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (NodeInt aux = this.top; aux != null; aux = aux.next) {
            res.append(aux.data).append("\n");
        }
        return res.toString();
    }
    /**
     * Checks if this stack is equal to another object.
     * Two stacks are equal if they have the same elements in the same order.
     * @param o Object to compare with.
     * @return boolean, true if the stacks are equal, false otherwise.
     */
    public boolean equals(Object o) {
        if (!(o instanceof StackIntLinked s)) {
            return false;
        }
        if (this.size != s.size) {
            return false;
        }
        NodeInt aux1 = this.top;
        NodeInt aux2 = s.top;
        while (aux1 != null && aux2 != null) {
            if (aux1.data != aux2.data) {
                return false;
            }
            aux1 = aux1.next;
            aux2 = aux2.next;
        }
        return true;
    }

    /**
     * Returns the element at the specified position in the stack.
     * @param i int, index of the element to return (0 is the top).
     * @throws IndexOutOfBoundsException if the index is out of range.
     * @return int, the element at the specified position.
     */
    public int get(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        NodeInt aux = this.top;
        for (int j = 0; j < i; j++) {
            aux = aux.next;
        }
        return aux.data;
    }

    /**
     * Moves the bottom element to the top of the stack and sets its value to the original top value.
     * The original top element is removed.
     * @throws NoSuchElementException if the stack is empty.
     */
    public void topBase(){
        if (this.top == null) {
            throw new NoSuchElementException("Empty stack");
        }
        NodeInt aux = this.top;
        int auxData = aux.data;
        while (aux.next != null) {
            aux = aux.next;
        }
        this.top = aux;
        aux.data = auxData;
    }

    /**
     * Pushes an element onto the stack after its last occurrence.
     * If the element is not in the stack, it is pushed to the top.
     * @param x int, the element to push.
     * @return int, the position where the element was inserted (1 is the top).
     */
    public int pushR(int x){
        int count = 0;
        NodeInt aux = this.top;
        NodeInt lastAppeared = null;
        while (aux != null) {
            if (aux.data == x) {
                lastAppeared = aux;
                count++;
            }
            aux = aux.next;
        }

        if (count == 0) {
            this.top = new NodeInt(x, this.top);
            this.size++;
            return 1;
        } else {
            lastAppeared.next = new NodeInt(x, lastAppeared.next);
            this.size++;
            return count + 1;
        }
    }
}
