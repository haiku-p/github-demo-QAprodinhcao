public class DynamicQueues2{
    private int capacity;
    int queuesArray[];
    int front = 0;
    int rear = -1;
    int currentSize = 0;

    public DynamicQueues2(int queueSize){
        this.capacity = queueSize;
        queuesArray = new int[this.capacity];
    }

    // Adds element at the end of the queue
    public void endqueue(int item){
        if (isQueueFull()){
            System.out.println("Overflow state. Increase capacity. ");
            increaseCapacity();
        } else {
            rear++;
            if(rear == capacity - 1){
                rear = 0;
            }
        }
        queuesArray[rear] = item;
        currentSize++;
        System.out.println("Element " + item + " is pushed to Queue. ");
    }

    //Removes an element from the top of the queue
    public void dequeue(){
        if(isQueueEmpty()){
            System.out.println("Underflow state. ");
        } else {
            front++;
            if(front == capacity - 1){
                System.out.println("Removal element: "+queuesArray[front - 1]);
                front = 0;
            } else {
                System.out.println("Removal element: "+queuesArray[front - 1]);
            }
            currentSize--;
        }
    }

    //Checks whether the queue is full or not
    public boolean isQueueFull(){
        boolean status = false;
        if (currentSize == capacity){
            status = true;
        }
        return status;
    }

    //Check whether the queue is empty or not
    public boolean isQueueEmpty(){
        boolean status = false;
        if (currentSize == 0){
            status = true;
        }
        return status;
    }

    private void increaseCapacity(){
        //Create new array with double size as the current one.
        int newCapacity = this.queuesArray.length * 2;
        int[] newArr = new int [newCapacity];

        //Copy elements to new array
        int tmpFront = front;
        int index = -1;
        while(true){
            newArr[++index] = this.queuesArray[tmpFront];
            tmpFront++;
            if(tmpFront == this.queuesArray.length){
                tmpFront = 0;
            }
            if(currentSize == index + 1){
                break;
            }
        }

        //Convert new array as queue
        this.queuesArray = newArr;
        System.out.println("New array capacity: " + this.queuesArray.length);

        //Reset front and rear values
        this.front = 0;
        this.rear = index;
    }

    public static void main(String[] args) {
        try {
            DynamicQueues2 queue = new DynamicQueues2(4);
            queue.endqueue(41);
            queue.dequeue();
            queue.endqueue(5);
            queue.endqueue(6);
            queue.endqueue(24);
            queue.endqueue(7);
            queue.endqueue(4);
            queue.endqueue(45);
            queue.dequeue();;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}