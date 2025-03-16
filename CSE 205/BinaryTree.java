
public class MyBSTree<T extends Comparable<T>> implements ITree<T> {
    private Node root;
    private int size;  
    
    class Node {
        public T data;
        public Node left;  
        public Node right; 
        
        public Node(T data) {
            this.data = data;
            this.left = null;  
            this.right = null;
        }
        
        public void insert(T item) {
            int compareResult = item.compareTo(data);
            
            if (compareResult == 0) { 
                return;
            } else if (compareResult < 0) {  
                if (left == null) {
                    left = new Node(item);
                    size++;  
                } else {
                    left.insert(item);  
                }
            } else {  // Go right
                if (right == null) {
                    right = new Node(item);
                    size++;
                } else {
                    right.insert(item);  
                }
            }
        }
    }
    
    @Override
    public void insert(T item) {
        if (root == null) {  
            root = new Node(item);
            size = 1;  
        } else {
            root.insert(item);  
        }
    }
    
    @Override
    public boolean containsItem(T item) {
        return containsItemHelper(root, item);
    }
    
    private boolean containsItemHelper(Node node, T item) {
        if (node == null) return false;  
        
        int cmp = item.compareTo(node.data);
        if (cmp == 0) return true;
        return cmp < 0 
            ? containsItemHelper(node.left, item)  
            : containsItemHelper(node.right, item); 
    }
    
    @Override
    public int getSize() {
        return size; 
    }
    
    @Override
    public void printInOrder() {
        printInOrderHelper(root);
        System.out.println(); 
    }
    
    private void printInOrderHelper(Node node) {
        if (node != null) {
            printInOrderHelper(node.left);
            System.out.print(node.data + " "); 
            printInOrderHelper(node.right);
        }
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        toStringHelper(root, result);
        return result.toString().trim(); 
    }
    
    private void toStringHelper(Node node, StringBuilder sb) {
        if (node != null) {
            toStringHelper(node.left, sb);
            sb.append(node.data).append(" "); 
            toStringHelper(node.right, sb);
        }
    }
}
