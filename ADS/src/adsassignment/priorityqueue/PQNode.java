package adsassignment.priorityqueue;

public class PQNode<T> implements Comparable<PQNode<T>> {

    private T element;
    private double priority;
    private PQNode<T> next,last;
    
    public PQNode(T element, double priority) {
        this.element = element;
        this.priority = priority;
        next = last = null;
    }
    

    /**
     * Returns less than zero, if this PQNode's priority is less than the parameter PQNode.
     * @param tpqNode node to compare against
     * @return integer based on the comparison
     */
    @Override
    public int compareTo(PQNode<T> tpqNode) {
        return priority < tpqNode.priority ? -1 : 1;
    }
    
    public PQNode<T> getNext(){
    	return next;
    }
    
    public PQNode<T> getLast(){
    	return last;
    }
    
    public void setNext(PQNode<T> next)
    {
    	this.next = next;
    }
    
    public void setLast(PQNode<T> last)
    {
    	this.last = last;
    }
    
    public T getElement(){
    	return element;
    }
    
    public double getPriority()
    {
    	return priority;
    }
    
}
