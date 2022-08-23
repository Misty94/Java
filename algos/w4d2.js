class QueueNode { // Queue works for printers or hardware or registers and algorithms when you need a graph
    constructor(data) {
      this.data = data;
      this.next = null;
    }
  }
  
  class LinkedListQueue {
    constructor() {
      this.head = null;
      this.tail = null;
    }
  
    /**
   * Adds a new given item to the back of this queue.
   * - Time: O(1) constant.
   * - Space: O(1) constant.
   * @param {any} item The new item to add to the back.
   * @returns {this} So the method can be chained.
   */
    enqueue(item) {
        let newNode = new QueueNode(item);
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
            return this;
        }
        this.tail.next = newNode;
        this.tail = newNode;
        return this;
     }
  
    /**
     * Removes and returns the first item of this queue.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {any} The first item or undefined if empty.
     */
    dequeue() {
        if (this.head == null) return null;
        let temp = this.head;
        this.head = this.head.next; // moving the head back
        temp.next = null; // sever the connection
        return temp;
     }
  
    /**
     * Retrieves the first item without removing it.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {any} The first item or undefined if empty.
     */
    front() {
        if (this.head == null) return null;
        return "The front is " + this.head.data;
     }
  
    /**
     * Returns whether or not this queue is empty.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {boolean}
     */
    isEmpty() { 
        if (this.head == null) return true;
        return false;
    }
  
    /**
     * Retrieves the size of this queue.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {number} The length.
     */
    size() { // no runner
     var length = 0;
     if (this.isEmpty()){
        return length;
     }
     let temp = new LinkedListQueue();
     while (this.head){
        length++;
        temp.enqueue(this.dequeue().data)
     }
     while (temp.head){ // have to make sure the original queue stays the same
        this.enqueue(temp.dequeue().data)
     }
     return length;
    }
  
  
  
    
    queueToArray() {
        let temp = new LinkedListQueue();
        let output = ["Head->"]
        while(this.head) temp.enqueue(this.dequeue().data)
        while(temp.head){
            output.push(temp.head.data)
            this.enqueue(temp.dequeue().data)
        } 
        output.push("<-Tail")
        return output
    }
  }
  
  const queue = new LinkedListQueue();
  // comment out after enqueue is finished
  queue.enqueue(34).enqueue(78).enqueue(87).enqueue(34).enqueue(56).enqueue(15)
//   console.log(queue);
  console.log(queue.queueToArray())
  console.log(queue.front());
//   console.log(queue.dequeue()); // it works!
  console.log(queue.isEmpty());
//   console.log(queue.queueToArray().length); // gave the number 8 because "head" and "tail" are typed in there as strings
console.log(queue.size());