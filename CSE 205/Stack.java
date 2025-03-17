public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display(); 

        System.out.println(stack.pop()); 
        stack.display(); 
        System.out.println(stack.pop()); 
        stack.display(); 
        System.out.println(stack.pop()); 

        stack.display(); 
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

class Stack {
    Node head;

    Stack() {
        this.head = null;
    }

    public void push(int value) {
        Node newnode = new Node(value);
        if (head == null) {
            head = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }
    }

    public int pop() {
        if (head == null) {
            throw new IllegalStateException("Stack is empty");
        } else {
            int value = head.data;
            head = head.next;
            return value;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("Stack is empty");
        } else {
            Node current = head;
            System.out.print("Stack: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}
