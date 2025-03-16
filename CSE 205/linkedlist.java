import java.util.*;

class Main {
    public static void main(String[] args) {  // Corrected main method signature
        // create node
        Node head = new Node(5);
        System.out.print("Initial list: ");
        print(head);
        // create node at beginning
        head = addBeg(head, 2);
        System.out.print("After addBeg: ");
        print(head);
        // create node at end
        head = addEnd(head, 7);
        System.out.print("After addEnd: ");
        print(head);
        // create node at index
        head = addInd(head, 2, 9);
        System.out.print("After addInd: ");
        print(head);
        // delete node at beginning
        head = delBeg(head);
        System.out.print("After delBeg: ");
        print(head);
        // delete node at end
        head = delEnd(head);
        System.out.print("After delEnd: ");
        print(head);
        // delete node at index
        head = delInd(head, 1);
        System.out.print("After delInd: ");
        print(head);
        // print size of node
        getSize(head);
        // print nodes
        System.out.print("Final list: ");
        print(head);
    }

    public static Node addBeg(Node head, int value) {
        Node temp = new Node(value);
        if (head == null) {
            return temp;
        }
        temp.next = head;
        return temp;
    }

    public static Node addEnd(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) {
            return newNode;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public static Node addInd(Node head, int index, int value) {
        if (head == null || index < 0) {
            return head;
        }
        
        if (index == 0) {
            return addBeg(head, value);
        }

        Node newNode = new Node(value);
        Node current = head;
        int i = 0;
        
        while (current != null && i < index - 1) {
            current = current.next;
            i++;
        }
        
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
        
        return head;
    }

    public static Node delBeg(Node head) {
        if (head == null) {
            return null;
        }
        return head.next;
    }

    public static Node delEnd(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        return head;
    }

    public static Node delInd(Node head, int index) {
        if (head == null || index < 0) {
            return head;
        }
        
        if (index == 0) {
            return delBeg(head);
        }

        Node current = head;
        int i = 0;
        
        while (current != null && i < index - 1) {
            current = current.next;
            i++;
        }
        
        if (current != null && current.next != null) {
            current.next = current.next.next;
        }
        
        return head;
    }

    public static void getSize(Node head) {
        Node current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        System.out.println("Size of linked list: " + size);
    }

    public static void print(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class Node {
    int data;
    Node next;
  
    Node(int data) {
       this.data = data;
       this.next = null;  // Initialize next as null
    }
}