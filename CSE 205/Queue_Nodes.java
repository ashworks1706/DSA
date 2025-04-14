public class Queue_Nodes {
    public static void main(String[] args) {
         Queue queue = new  Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display(); 

        System.out.println(queue.dequeue()); 
        queue.display(); 
        System.out.println(queue.dequeue()); 
        queue.display(); 
        System.out.println(queue.dequeue()); 

        queue.display(); 
    }
}

class Node {
    int data;
    Node next;
  
    Node(int data) {
       this.data = data;
       this.next = null;  
    }
}

class  Queue {
    Node head;

     Queue() {
        this.head = null;
    }

    public void enqueue(int value) {
        Node newnode = new Node(value);
        if (head == null) {
            head = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }
    }

    public int dequeue() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        } else {
            Node current = head;
            Node previous = null;
            while (current.next != null) {
                previous = current;
                current = current.next;
            }
            int value = current.data;
            if (previous != null) {
                previous.next = null;
            } else {
                head = null;
            }
            return value;
        }
    }
    

    public void display() {
        if (head == null) {
            System.out.println("Queue is empty");
        } else {
            Node current = head;
            System.out.print("Queue: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}
