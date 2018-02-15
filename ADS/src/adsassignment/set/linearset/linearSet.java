package adsassignment.set.linearset;

import adsassignment.set.ISet;

public class linearSet<T extends Comparable<T>> implements ISet<T> {

	private final static int VALUE = 100;
	private T[] box;
	private int size;
	
	public linearSet() {
		box = (T[]) new linearSet[50];
		size = 0;
	}

	@Override
	public void add(T element) {
		
		if (element == null)
			System.out.println("Invalid element!");

		for (int i = 0; i < size; i++) {
			box[i] = element;
		}
		size++;
	}

	@Override
	public boolean contains(T element) {
		for (int i = 0; i < box.length; i++) {
			if (box[i] == element)
				return true;
		}
		return false;
	}

	@Override
	public int size() {
		for (int i = 0; i < box.length; i++) {
			if (box[i] != null)
				size++;
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (box == null);
	}

	@Override
	public void printSet() {
		for (int i = 0; i < box.length; i++) {
			System.out.println("{"+ box[i] + ","+ "}" );
		}
	}

	@Override
	public void clear() {
		for (int i = 0; i < box.length; i++) {
			box[i] = null;
		}

	}

	@Override
	public void addRange(T... range) {
		// TODO Auto-generated method stub
		for(T t : range){
			add(t);
		}
	}
}
