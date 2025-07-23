import java.util.NoSuchElementException;

public class QueueIntLinked {
    private NodeInt first, last; 
    private int size;             

    /**
     * Creates an empty queue.
     */
    public QueueIntLinked() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Adds x to the queue.
     * @param x int, the element to enqueue.
     */
    public void add(int x) {
        NodeInt node = new NodeInt(x);
        if (this.last != null) { this.last.next = node; }
        else { this.first = node; }
        this.last = node;
        this.size++;
    }

    /**
     * Returns and removes the first element of the queue.
     * @throws NoSuchElementException if the queue is empty.
     * @return int, the head element.
     */
    public int remove() {
        if (this.size == 0) { 
            throw new NoSuchElementException("Empty queue");
        }
        int x = this.first.data;
        this.first = this.first.next;
        if (this.first == null) { this.last = null; }
        this.size--;
        return x;
    }
    
    /**
     * Returns the first element of the queue without removing it.
     * @throws NoSuchElementException if the queue is empty.
     * @return int, the head element.
     */
    public int element() { 
        if (this.size == 0) { 
            throw new NoSuchElementException("Empty queue");
        }
        return this.first.data; 
    }

    /**
     * Checks if the queue is empty.
     * @return boolean, true if and only if the queue is empty.
     */
    public boolean empty() { 
        return (this.first == null); // or return this.size == 0;
    }
    
    /**
     * Returns the number of elements in the queue.
     * @return int, the size.
     */
    public int size() { return this.size; }
    
   
    /**
     * Returns a String formed by the successive values of the queue.
     * If the queue is empty, returns "".
     * @return String, the string representation of the queue.
     */
    public String toString() {
        StringBuilder s = new StringBuilder("<-");
        NodeInt aux = this.first;
        while (aux != null) {
            s.append(String.format("%4d", aux.data));
            aux = aux.next;
        }
        return s + "  <-";
    }

    /**
     * Splits the queue into two parts.
     * Keeps the first n elements in the original queue and returns a new queue with the remaining elements.
     * @param n int, the number of elements to keep in the original queue.
     * @throws IllegalArgumentException if n is negative or greater than the size of the queue.
     * @return QueueIntLinked, a new queue containing the elements after the first n elements.
     */
    public QueueIntLinked cut(int n){
        if(n<0 || n>this.size){
            throw new IllegalArgumentException("n: incorrect number of elements");
        }

        QueueIntLinked newQueue = new QueueIntLinked();
        if(n==0){
            newQueue.first = this.first;
            newQueue.last = this.last;
            newQueue.size = this.size;
            this.first = null;
            this.last = null;
            this.size = 0;
        } else if (n < this.size){
            int cont = 1; NodeInt aux = this.first;
            while (cont < n) { aux = aux.next; cont++; }
            newQueue.first = aux.next; newQueue.last = this.last; newQueue.size = this.size - n;
            this.last = aux; this.last.next = null; this.size = n;
        }
        return newQueue;
    }
    
    /**
     * Adds a mirror image of the queue to the end of the queue.
     * For example, if the queue is [1,2,3], after mirrorize() it becomes [1,2,3,3,2,1].
     */
    public void mirrorize(){
        NodeInt aux = this.first, added = null, newLast = null;
        while(aux.next != null){
            added = new NodeInt(aux.data, added);
            if (newLast == null) { newLast = added; }
            aux = aux.next;
        }
        aux.next = added;
        this.last = newLast;
        this.size *= 2;
    }

    /**
     * Reverses the order of elements in the queue.
     * For example, if the queue is [1,2,3], after reverse() it becomes [3,2,1].
     */
    public void reverse(){
        NodeInt aux = this.first , prev = null, next, newLast = this.first;
        this.first = this.last;
        while(aux != null){
            next = aux.next;
            aux.next = prev;
            prev = aux;
            aux = next;
        }
        this.last = newLast;
    }

    /**
     * Divides the queue into three equal parts and rearranges them.
     * The order becomes [third part, second part, first part].
     * For example, if the queue is [1,2,3,4,5,6], after swapThirds() it becomes [5,6,3,4,1,2].
     */
    public void swapThirds(){
        int lastOfFirstThird = this.size / 3;
        int lastOfSecondThird = 2 * lastOfFirstThird;

        NodeInt firstOfMiddle = this.first;
        NodeInt lastOfFirst = null;

        for (int i = 0; i < lastOfFirstThird; i++) {
            if(i == lastOfFirstThird-1){ lastOfFirst = firstOfMiddle; }
            firstOfMiddle = firstOfMiddle.next;
        }

        NodeInt lastOfMiddle = firstOfMiddle;
        for (int i = lastOfFirstThird+1; i < lastOfSecondThird; i++) {
            lastOfMiddle = lastOfMiddle.next;
        }

        this.last.next = firstOfMiddle;
        NodeInt aux = this.first;
        this.first = lastOfMiddle.next;
        lastOfMiddle.next = aux;
        assert lastOfFirst != null;
        lastOfFirst.next = null;
        this.last = lastOfFirst;
    }

    /**
     * Removes consecutive repeated values from the queue.
     * For example, if the queue is [1,2,2,2,3,3,4], after removeRepeatedValues() it becomes [1,2,3,4].
     */
    public void removeRepeatedValues(){
        if(size < 2) return;
        NodeInt aux = this.first.next, prev = this.first;
        while(aux != null){
            if(aux.data == prev.data){
                aux = aux.next;
                size--;
                continue;
            }
            prev.next = aux;
            prev = aux;
            aux = aux.next;
        }
        this.last = prev;
        this.last.next = null;
    }

    /**
     * Adds an element to the queue in sorted order (ascending).
     * Assumes the queue is already sorted.
     * @param d int, the element to add.
     */
    public void addSorted(int d){
        if(size == 0 || first.data >= d){
            first = new NodeInt(d, first);
            if(last == null){ last = first; }
        } else if(last.data <= d){
            last.next = new NodeInt(d);
            last = last.next;
        } else {
            NodeInt aux = first.next, prev = first;
            while (aux != null && aux.data < d) {
                prev = aux;
                aux = aux.next;
            }
            prev.next = new NodeInt(d, aux);
        }
        size++;
    }

    /**
     * Replaces the first occurrence of value x with two values: x/2 and (x/2)+(x%2).
     * For example, if x=5, it's replaced with 2 and 3.
     * @param x int, the value to split.
     */
    public void split(int x){
        if(first.data == x){
            first = new NodeInt((x/2) + (x%2), first.next);
            first = new NodeInt(x/2, first);
            if(size == 1){
                last = first.next;
            }
            size++;
            return;
        }
        NodeInt aux = this.first.next, prev = this.first;
        boolean found = false;
        while(aux != null && !found){
            if(aux.data == x){
                found = true;
                prev.next = new NodeInt((x/2) + (x%2),aux.next);
                if(aux.next == null){
                    this.last = prev.next;
                }
                prev.next = new NodeInt(x/2, prev.next);
                size++;
            }
            prev = aux;
            aux = aux.next;
        }
    }
}