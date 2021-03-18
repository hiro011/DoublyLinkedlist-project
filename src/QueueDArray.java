public class QueueDArray {

    private int capacity = 5;
    int queueArr[];
    int front = 0;
    int rear = -1;
    int currentSize = 0;

    public QueueDArray() {
        queueArr = new int[this.capacity];
    }

    public void enqueue(int item) {

        if (isQueueFull()) {
            System.out.println("Queue is full, increase capacity...");
            increaseCapacity();
        }
        rear++;
        queueArr[rear] = item;
        currentSize++;
        System.out.println(item+" is added.");
    }

    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow!");
        } else {
            front++;
            if (front > queueArr.length - 1) {
                System.out.println(queueArr[front - 1]+" is removed.");
                front = 0;
            } else {
                System.out.println("removed: " + queueArr[front - 1]);
            }
            currentSize--;
        }
    }
    public void peek(){
        if (isQueueEmpty()) {
            System.out.println("Underflow!");
        } else  System.out.println("Top element: " + queueArr[front]);
    }

    public boolean isQueueFull() {
        return  currentSize == queueArr.length;
    }

    public boolean isQueueEmpty() {
       return currentSize == 0;
    }

    private void increaseCapacity() {
        int newCapacity = this.queueArr.length * 2;
        int[] newArr = new int[newCapacity];
        int tmpFront = front;
        int index = -1;
        while (true) {
            newArr[++index] = this.queueArr[tmpFront];
            tmpFront++;
            if (currentSize == index + 1) {
                break;
            }
        }

        this.queueArr = newArr;
        System.out.println("New array capacity: " + this.queueArr.length);
        this.rear = index;
    }
    public void despaly(){
        int r = front;
        if (!isQueueEmpty()) {
            for (int x = 0; x < currentSize; x++) {
                System.out.print(queueArr[r] + " ");
                r++;
            }
        }else System.out.println("Queue is empty.");
        System.out.println();
    }

    public static void main(String[] args) {
        QueueDArray q = new QueueDArray();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(9);
        q.enqueue(28);
        q.enqueue(35);
        q.enqueue(42);
        q.enqueue(51);
        q.enqueue(62);
        q.peek();
        q.dequeue();
        q.peek();
        q.dequeue();
        q.peek();
        q.dequeue();
        q.peek();
        q.dequeue();
        q.peek();
        q.despaly();

    }
}
