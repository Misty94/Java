/**

 * Class to represent a MinHeap which is a Priority Queue optimized for fast
 * retrieval of the minimum value. It is implemented using an array but it is
 * best visualized as a tree structure where each 'node' has left and right
 * children except the 'node' may only have a left child.
 * - parent is located at: Math.floor(i / 2);
 * - left child is located at: i * 2
 * - right child is located at: i * 2 + 1
 */
 class MinHeap {

    constructor() {
      /**
       * 0th index not used, so null is a placeholder. Not using 0th index makes
       * calculating the left and right children's index cleaner.
       * This also effectively makes our array start at index 1.
       */
      this.heap = [null];
    }
  
    //returns the index of the left child
    idxOfLeftChild(i) {
      return i * 2;
    }
  
    //returns the index of the right child
    idxOfRightChild(i) {
      return i * 2 + 1;
    }
  
    /**
   * Extracts the min num from the heap and then re-orders the heap to
   * maintain order so the next min is ready to be extracted.
   * 1) Check if null
   * 2)Store min value (index of 1) heap[1] in temp variable
   * 3) Move last heap num heap[heap.length-1] in heap to the heap[1]
   * 4) Shift Down
   * - Time: O(log n) logarithmic due to shiftDown.
   * - Space: O(1) constant.
   * @returns {?number} The min number or null if empty.
   */
    // I COMPLETELY LOST TRACK OF THIS! but it works
    extract() {
        if (!this.heap) return null;
        let temp = this.heap[1];
        this.heap[1] = this.heap.pop();
        // this.heap[1] = this.heap[this.heap.length-1]; // resetting the top num with the max val / moves last value in array to the top
        // let parent = Math.floor((this.heap.length-1)/2);
        let nodeToBeShiftedDown = 1;
        let indexOfLeftChild = this.idxOfLeftChild(nodeToBeShiftedDown);
        while (indexOfLeftChild < this.heap.length){ // breakout condition
            let indexOfRightChild = this.idxOfRightChild(nodeToBeShiftedDown);
            let isRightNull = indexOfRightChild > this.heap.length; // this is a boolean? that will be true if this is correct?
            if (isRightNull == false){
                if (this.heap[indexOfLeftChild] > this.heap[indexOfRightChild]){ // can use Math.min here instead of if
                var smallestChildIdx = indexOfRightChild;
                } else {
                    var smallestChildIdx = indexOfLeftChild;
                }
            } else {
                var smallestChildIdx = indexOfLeftChild;
            }
            if (this.heap[nodeToBeShiftedDown] > this.heap[smallestChildIdx]){
                let tempSwap = this.heap[nodeToBeShiftedDown];
                this.heap[nodeToBeShiftedDown] = this.heap[smallestChildIdx];
                this.heap[smallestChildIdx] = tempSwap;
            } else {
                return temp;
            }
            nodeToBeShiftedDown = smallestChildIdx;
            indexOfLeftChild = this.idxOfLeftChild(nodeToBeShiftedDown);
        }
        return temp;
     }
  
  
  
  
    insert(num) {
      let idxNewNode = this.heap.length;
      this.heap.push(num);
      while (idxNewNode > 1) {
        const idxOfParent = Math.floor(idxNewNode / 2);
        const isParentSmallerOrEqual =
          this.heap[idxOfParent] <= this.heap[idxNewNode];
        // Parent is supposed to be smaller so ordering is complete.
        if (isParentSmallerOrEqual) {
          break;
        }
        [this.heap[idxNewNode], this.heap[idxOfParent]] = [this.heap[idxOfParent], this.heap[idxNewNode]];
        // after swapping the node is at idxOfParent now.
        idxNewNode = idxOfParent;
        // .push on array returns the new length
      }
      return this.heap.length - 1;
    }
  
    printHorizontalTree(parentIdx = 1, spaceCnt = 0, spaceIncr = 10) {
      if (parentIdx > this.heap.length - 1) {
        return;
      }
  
      spaceCnt += spaceIncr;
      this.printHorizontalTree(parentIdx * 2 + 1, spaceCnt);
  
      console.log(
        " ".repeat(spaceCnt < spaceIncr ? 0 : spaceCnt - spaceIncr) +
        `${this.heap[parentIdx]} (${parentIdx})`
      );
  
      this.printHorizontalTree(parentIdx * 2, spaceCnt);
    }
  }
  
  
  var heap = new MinHeap();
  
  const miniHeap = new MinHeap();
  miniHeap.insert(3)
  miniHeap.insert(45)
  miniHeap.insert(22)
  miniHeap.insert(21)
  miniHeap.insert(13)
  miniHeap.insert(78)
  miniHeap.insert(65)
  miniHeap.printHorizontalTree()
  console.log(miniHeap.extract());
  miniHeap.printHorizontalTree()