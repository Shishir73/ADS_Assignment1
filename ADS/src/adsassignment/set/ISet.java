package adsassignment.set;

public interface ISet<T extends Comparable<T>> {
	
	public void add(T element);
	
	public boolean contains(T element);

	public int size();
	
	public boolean isEmpty();
	
	public void printSet();
	
	public void clear();
	
	public void addRange(T... range);
}