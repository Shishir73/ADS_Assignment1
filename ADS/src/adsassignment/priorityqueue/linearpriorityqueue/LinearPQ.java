package adsassignment.priorityqueue.linearpriorityqueue;

import adsassignment.priorityqueue.IPriorityQueue;
import adsassignment.priorityqueue.PQNode;

public class LinearPQ<T> implements IPriorityQueue<T> {

	private PQNode<T> front, rear;
	private int size;

	public LinearPQ() {
		size = 0;
		front = rear = null;
	}

	@Override
	public void add(T element, double priority) {
		if (element == null) { //throw new IllegalArgumentException();
			} 
		else 
		{
			PQNode<T> node = new PQNode<T>(element, priority);
			
			if(isEmpty())
			{
				front = rear = node;
			}
			else if(node.getPriority() < front.getPriority())
			{
				node.setNext(front);
				front.setLast(node);
				front = node;
			}
			else if(rear.getPriority() <= node.getPriority())
			{
				rear.setNext(node);
				node.setLast(rear);
				rear = node;
			}
			else
			{
				PQNode<T> current = front;
				while(!(node.getPriority() < current.getPriority()))
				{
					current = current.getNext();
				}
				node.setNext(current);
				node.setLast(current.getLast());
				current.getLast().setNext(node);
				current.setLast(node);
			}
			size++;
		}
	}

	@Override
	public T getNext() {
		// TODO Auto-generated method stub
		if (isEmpty()) 
		{
			return null;
		}
		else
		{
			T element = front.getElement();
			front = front.getNext();
			size--;
			
			if(isEmpty())
			{
				rear = null;
			}
			
			return element;
		}

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public void printPQ() {
		String str = "";
		PQNode<T> current = front;
		for (int i = 0; i < size; i++) {
			str += " (" + current.getElement() + ", " + current.getPriority()
					+ ")";
			current = current.getNext();
		}
		System.out.println(str);

	}

	@Override
	public boolean contains(T element) {
		if(element == null){
			return false;
		}
		else 
		{
			PQNode<T> current = front;
			for (int i = 0; i < size; i++) {
				if(current.getElement().equals(element))
				{
					return true;
				}
				current = current.getNext();
			}
		}
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		front = rear = null;
		size = 0;
	}
}
