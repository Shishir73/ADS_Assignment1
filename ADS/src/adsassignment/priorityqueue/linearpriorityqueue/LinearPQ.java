package adsassignment.priorityqueue.linearpriorityqueue;

import adsassignment.priorityqueue.IPriorityQueue;
import adsassignment.priorityqueue.PQNode;

public class LinearPQ<T> implements IPriorityQueue<T> {

	private PQNode<T> front;
	private int size;

	public LinearPQ() {
		size = 0;
		front = null;
	}

	@Override
	public void add(T element, double priority) {
		if (element == null) {
			//throw new IllegalArgumentException();
		} else {
			PQNode<T> temp = new PQNode<T>(element, priority);
			if (front == null) {
				front = temp;
				front.setNext(front);
			} else {
				if (front.getNext() == front) {
					if (front.getPriority() > priority) {
						temp.setNext(front);
						front = temp;
					} else {
						front.setNext(temp);
						temp.setNext(front);
					}
				} else {
					PQNode<T> current = front;
					while (current.hasNext()
							&& !current.getNext().equals(front)) {
						if (current.getNext().getPriority() > priority) {
							temp.setNext(current.getNext());
							current.setNext(temp);
						} else if (current.getNext().getNext().equals(front)) { //if the priority is the lowest then put it at the end of the queue.
							temp.setNext(front);
							current.getNext().setNext(temp);
						}
						current = current.getNext();
					}
				}
			}
			size++;
		}
	}

	@Override
	public T getNext() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return null;
		}else{
		PQNode<T> temp = front;
			size--;
			front = front.getNext();
			return temp.getElement();
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
		if(element.equals(null)){
			return false;
		}
		else if (front.getElement().equals(element)) {
			return true;
		} else {
			PQNode<T> current = front;
			while (current.hasNext() && !current.getNext().equals(front)) {
				if (current.getNext().getElement().equals(element)) {
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
		front = null;
	}
}
