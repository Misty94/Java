class node{
    constructor(data) {
      this.data = data
      this.next = null
      this.prev = null
    }
  }
  
  /**
   * A class to represent a doubly linked list and contain all of it's methods.
   * A doubly linked list is a singly linked list that can be traversed in both
   * directions.
   */
  class DoublyLinkedList {
    /**
     * Executed when the new keyword is used to construct a new DoublyLInkedList
     * instance that inherits these methods and properties.
     */
    constructor() {
      this.head = null
      this.tail = null
    }
  
    /**
     * Creates a new node and adds it at the front of this list.
     * - Time: O(?).
     * - Space: O(?).
     * @param {any} data The data for the new node.
     * @returns {DoublyLinkedList} This list.
     */
    insertAtFront(data) {
        var newNode = new node(data);
        if (!this.head){
            this.head = newNode;
            this.tail = newNode;
            return this;
        }
        var temp = this.head;
        this.head = newNode;
        newNode.next = temp;
        newNode.prev = newNode;
        while (temp.next){
            temp = temp.next;
            // temp.prev = newNode;
            // newNode.next = this.head;
            // this.head = newNode;
        }
        this.tail = temp;
        return this;
    }

    // Brian's Solution
    insertAtFront(data) {
        var newNode = new node(data);
        if (!this.head){
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        return this;
    }

  
    /**
     * Creates a new node and adds it at the back of this list.
     * - Time: O(?).
     * - Space: O(?).
     * @param {any} data The data for the new node.
     * @returns {DoublyLinkedList} This list.
     */
    insertAtBack(data) {
        const newTail = new node(data);
        
        if (!this.head){
            this.head = newTail;
            this.tail = newTail;
        } else {
            this.tail.next = newTail;
            newTail.prev = this.tail;
            this.tail = newTail;
        }
        return this; // inserts at the back
    }
  
    // EXTRA
    /**
     * Removes the middle node in this list.
     * - Time: O(?).
     * - Space: O(?).
     * @returns {any} The data of the removed node.
     */
    removeMiddleNode() {
        if (!this.head){
            return null;
        }
        var counter = 1;
        var runner = this.head;
        while (runner.next){ // so we can add to our counter
            counter++;
            runner = runner.next;
        }// runner is now at the end of the list
        if (counter % 2 === 0){
            return null;
        } else {
            for (let i = 0; i < Math.floor(counter/2); i++){
                runner = runner.prev;
            } // runner will be back at beginning ?
            runner.next.prev = runner.prev; // point it past the runner
            runner.prev.next = runner.next; // opposite 
            runner.next = null; // to cut off the pointers
            runner.prev = null;
        }
        return runner.data;
    }
  
    /**
     * Determines if this list is empty.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {boolean} Indicates if this list is empty.
     */
    isEmpty() {
      return this.head === null;
    }
  
    /**
     * Converts this list to an array of the node's data.
     * - Time: O(n) linear, n = list length.
     * - Space: O(n) linear, array grows as list length increases.
     * @returns {Array<any>} All the data of the nodes.
     */
    toArray() {
      const vals = [];
      let runner = this.head;
  
      while (runner) {
        vals.push(runner.data);
        runner = runner.next;
      }
      return vals;
    }
  
    /**
     * Adds all the given items to the back of this list.
     * @param {Array<any>} items Items to be added to the back of this list.
     * @returns {DoublyLinkedList} This list.
     */
    insertAtBackMany(items = []) {
      items.forEach((item) => this.insertAtBack(item));
      return this;
    }
  }
  
  const emptyList = new DoublyLinkedList();

const singleNodeList = new DoublyLinkedList().insertAtFront(1);
const biNodeList = new DoublyLinkedList().insertAtFront(1).insertAtFront(2);
console.log(biNodeList.toArray());
  
  /**************** Uncomment these test lists after insertAtBack is created. ****************/
  const singleNodeList2 = new DoublyLinkedList().insertAtBack(1);
  const biNodeList2 = new DoublyLinkedList().insertAtBack(1).insertAtBack(2);
  console.log(biNodeList2.toArray());
  // const firstThreeList = new DoublyLinkedList().insertAtBackMany([1, 2, 3]);
  // const secondThreeList = new DoublyLinkedList().insertAtBackMany([4, 5, 6]);
  