public class DLL {
    private DllNode head = null;
    private DllNode tail = null;
    class DllNode{
        int data;
        DllNode next;
        DllNode prev;

        public DllNode(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void addToHead(int data){
        DllNode first = new DllNode(data);
        if(this.head == null){
            System.out.println(data+" is added to head.");
            this.head = first;
            this.tail = first;
        }else {
            System.out.println(data+" is added to head.");
            this.head.prev = first;
            first.next = this.head;
            this.head = first;
        }
    }
    public void addToTail(int data){
        DllNode sec = new DllNode(data);
        if (this.head == null){
            System.out.println(data+" is added to tail.");
            this.head = sec;
            this.tail = sec;
        }else {
            System.out.println(data+" is added to tail.");
            this.tail.next = sec;
            sec.prev = tail;
            this.tail = sec;
        }
    }
    public int deletHead(){
        if (this.head == null){
            System.out.println("Empty");
        }else {
            System.out.println(this.head.data + ", the head is deleted.");
           this.head = this.head.next;
           this.head.prev = null;
        }
        return -1;
    }
    public int deletTail(){
        if (this.head == null){
            System.out.println("Empty");
        }else {
            System.out.println(this.tail.data + ", the tail is deleted.");
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        return -1;
    }
    public void deletRandom(int data){
        if (this.head == null){
            System.out.println("Empty");
        }else {
           if (this.head.data == data && this.head.next == null){
               System.out.println("Head is deleted the list is now empty.");
               head = null;
               tail = null;
           }else if (this.head.data == data){
               System.out.println(data+" is deleted.");
               this.head = this.head.next;
               this.head.prev = null;
           }else {
               DllNode x = this.head;
               DllNode temp = null;
               while (x!= null && x.data != data){
                   temp = x;
                   x = x.next;
               }
               if (x== null) System.out.println("Not in the list");
               else {
                   if (x== this.tail){
                       System.out.println(data+" is deleted.");
                       this.tail = x.prev;
                       this.tail.next = null;
                   }else {
                       System.out.println(data+" is deleted.");
                       temp.next = x.next;
                       x.next.prev = temp;
                       x = null;
                   }
               }
           }
        }
    }
    public DllNode search(int data){
        DllNode x = this.head;
        if (this.head == null){
            System.out.println("Empty");

        }else {
            while (x != null && x.data != data) {
                x = x.next;
            }
            if (x == null) System.out.println("Not in the list");
            else return x;
        }
        return x;
    }


    public int getHead(){
        return this.head.data;
    }
    public int getTail(){
        return this.tail.data;
    }

    public void printList(){
        if (this.head != null) {
            DllNode x = head;
            System.out.print("the list is: ");
            while (x != null) {
                System.out.print(x.data + " ");
                x = x.next;
            }
            System.out.println();
        } else System.out.println("The list is empty.");
    }

    public static void main(String[] args) {
        DLL list = new DLL();
        list.addToHead(5);
        list.addToTail(7);
        list.addToHead(3);
        list.addToHead(9);
        list.addToHead(11);
        list.deletRandom(9);

        list.printList();
        try {
            System.out.println(list.search(11).data);
        }catch (NullPointerException e){ }
        list.printList();
        list.deletHead();
        list.printList();
        list.deletTail();
        list.printList();
    }
}
