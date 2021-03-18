public class StackDArray {
    int TotalSize;
    int CurrentSize;
    int[] arr;
    public StackDArray (int size){
        this.TotalSize = size;
        this.arr = new int[this.TotalSize];
        this.CurrentSize = 0;
    }
    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is full.");
        } else {
            arr[CurrentSize] = data;
            CurrentSize++;
            System.out.println(data + " is pushed.");
        }
    }
    public void pop(){
        if(isEmpty()){
            System.out.println("Stack is empty.");
        }else {
            System.out.println(arr[CurrentSize-1]+" is poped.");
            CurrentSize--;
        }
    }
    public void peek(){
        if (isEmpty()){
            System.out.println("Stack is empty.");
        }else System.out.println(arr[CurrentSize-1]+" is at the top.");
    }
    public void PrintStack(){
        if (isEmpty()){
            System.out.println("Stack is empty.");
        }else {
            System.out.print("Stack elemets are: ");
            for (int x=0; x<CurrentSize; x++){
                System.out.print(arr[x]+" ");
            }
        }
    }
    public boolean isEmpty(){
        return this.CurrentSize == 0;
    }
    public boolean isFull(){
        return this.CurrentSize == this.TotalSize;
    }
    public static void main(String[] args) {
        StackDArray list = new StackDArray(5);
        list.push(5);
        list.push(6);
        list.push(11);
        list.push(33);
        list.peek();
        list.pop();
        list.peek();
        list.PrintStack();

    }
}
