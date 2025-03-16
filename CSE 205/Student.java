class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double grade;
    
    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }
    
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }
    
    @Override
    public String toString() {
        return String.format("ID: %d Name: %s Grade: %.1f%%", id, name, grade);
    }
}