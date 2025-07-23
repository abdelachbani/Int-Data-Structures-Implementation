class NodeInt {
    int data;         
    NodeInt next;   
    
    /** Constructor A: creates a node with data d and no
     *  next node.
     *  @param d int.
     */ 
    NodeInt(int d) { 
        this.data = d; 
        this.next = null; 
    }
    
    /** Constructor B: creates a node with data d and with
     *  next node s.
     *  @param d int.
     *  @param s NodeInt.
     */ 
    NodeInt(int d, NodeInt s) { 
        this.data = d; 
        this.next = s; 
    }   
}
