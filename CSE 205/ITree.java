public interface ITree <T extends Comparable <T> >{
	public void insert(T item);
	public boolean containsItem(T item);
	public int getSize();
	public void printInOrder();
	public String toString();
}
