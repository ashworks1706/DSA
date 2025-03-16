class BST {
    private class Node {
        Student data;
        Node left, right;
        
        Node(Student data) {
            this.data = data;
        }
    }
    
    private Node root;
    
    public void insert(Student student) {
        root = insertRec(root, student);
    }
    
    private Node insertRec(Node root, Student student) {
        if (root == null) {
            return new Node(student);
        }
        
        if (student.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, student);
        } else if (student.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, student);
        }
        
        return root;
    }
    
    public Student search(int id) {
        return searchRec(root, id);
    }
    
    private Student searchRec(Node root, int id) {
        if (root == null || root.data.getId() == id) {
            return root == null ? null : root.data;
        }
        
        if (id < root.data.getId()) {
            return searchRec(root.left, id);
        }
        
        return searchRec(root.right, id);
    }
    
    public Student findHighestGrade() {
        return findHighestGradeRec(root);
    }
    
    private Student findHighestGradeRec(Node root) {
        if (root == null) return null;
        
        Student highest = root.data;
        Student leftHighest = findHighestGradeRec(root.left);
        Student rightHighest = findHighestGradeRec(root.right);
        
        if (leftHighest != null && leftHighest.getGrade() > highest.getGrade()) {
            highest = leftHighest;
        }
        if (rightHighest != null && rightHighest.getGrade() > highest.getGrade()) {
            highest = rightHighest;
        }
        
        return highest;
    }
    
    public Student findLowestGrade() {
        return findLowestGradeRec(root);
    }
    
    private Student findLowestGradeRec(Node root) {
        if (root == null) return null;
        
        Student lowest = root.data;
        Student leftLowest = findLowestGradeRec(root.left);
        Student rightLowest = findLowestGradeRec(root.right);
        
        if (leftLowest != null && leftLowest.getGrade() < lowest.getGrade()) {
            lowest = leftLowest;
        }
        if (rightLowest != null && rightLowest.getGrade() < lowest.getGrade()) {
            lowest = rightLowest;
        }
        
        return lowest;
    }
}
