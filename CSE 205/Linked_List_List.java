import java.util.*;

public class Linked_List_List {
    public static void main(String[] args) {
        // Create list
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        System.out.print("Initial list: ");
        print(list);
        
        // Add at beginning
        addBeg(list, 2);
        System.out.print("After addBeg: ");
        print(list);
        
        // Add at end
        addEnd(list, 7);
        System.out.print("After addEnd: ");
        print(list);
        
        // Add at index
        addInd(list, 2, 9);
        System.out.print("After addInd: ");
        print(list);
        
        // Delete at beginning
        delBeg(list);
        System.out.print("After delBeg: ");
        print(list);
        
        // Delete at end
        delEnd(list);
        System.out.print("After delEnd: ");
        print(list);
        
        // Delete at index
        delInd(list, 1);
        System.out.print("After delInd: ");
        print(list);
        
        // Print size
        getSize(list);
        
        // Print final list
        System.out.print("Final list: ");
        print(list);
    }
    
    public static void addBeg(LinkedList<Integer> list, int value) {
        list.addFirst(value);
    }
    
    public static void addEnd(LinkedList<Integer> list, int value) {
        list.addLast(value);
    }
    
    public static void addInd(LinkedList<Integer> list, int index, int value) {
        if (index >= 0 && index <= list.size()) {
            list.add(index, value);
        }
    }
    
    public static void delBeg(LinkedList<Integer> list) {
        if (!list.isEmpty()) {
            list.removeFirst();
        }
    }
    
    public static void delEnd(LinkedList<Integer> list) {
        if (!list.isEmpty()) {
            list.removeLast();
        }
    }
    
    public static void delInd(LinkedList<Integer> list, int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
        }
    }
    
    public static void getSize(LinkedList<Integer> list) {
        System.out.println("Size of linked list: " + list.size());
    }
    
    public static void print(LinkedList<Integer> list) {
        for (Integer item : list) {
            System.out.print(item + " -> ");
        }
        System.out.println("null");
    }
}