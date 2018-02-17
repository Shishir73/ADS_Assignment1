package adsassignment.set.linearset;

import adsassignment.set.ISet;
@SuppressWarnings("unchecked")
public class LinearSet<T extends Comparable<T>> implements ISet<T> {
	private T[] set;
	private int count;
	private int capacity = 100;
    
	public LinearSet() {
    	set = (T[]) new Object[capacity];
    	count = 0;
    }

    @Override
    public void add(T element) {
    	if(element == null)
    	{
    		
    	}
    	else if(contains(element))
    	{
    		System.out.println("element already exists");
    	}
    	else
    	{
    		if(count == set.length)
        	{
        		increaseCapacity();
        	}
    		set[count++] = element;    		
    	}
    }

	@Override
    public boolean contains(T element) {
    	for(T t : set)
    	{
    		if(t.equals(element) && element.equals(t))
    		{
    			return true;
    		}
    	}
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    @Override
    public void printSet() {
    	if(isEmpty())
    	{
    		System.out.println("{ }");
    	}
    	else
    	{
	    	String str = "{"+set[0];
	    	for(int i = 1; i < count; i++)
	    	{
	    		str+= ", "+set[i];
	    	}
	    	str += "}";
	    	System.out.println(str);
    	}
    }

    @Override
    public void clear() {
        set =  (T[]) new Object[capacity];
        count = 0;
    }
	
	@Override
    public void addRange(T... range) {
        for (T t : range) {
            add(t);
        }
    }
	
	private void increaseCapacity()
	{
		T[] temp = (T[]) new Object[capacity*2];
		for(int i = 0; i < set.length; i++)
		{
			temp[i] = set[i];
		}
		set = temp;
	}
}