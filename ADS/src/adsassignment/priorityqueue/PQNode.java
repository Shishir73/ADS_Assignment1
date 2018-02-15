package adsassignment.priorityqueue;

public class PQNode<T> implements Comparable<PQNode<T>> {

    public T element;
    public double priority;
    public int secPriority;
    private PQNode<T> front;

    public PQNode(T element, double priority, int secPriority) {
        this.element = element;
        this.priority = priority;
        this.secPriority = secPriority;
        front = null;
    }
    
    public PQNode(T element, double priority) {
        this.element = element;
        this.priority = priority;
        front = null;
    }
    

    /**
     * Returns less than zero, if this PQNode's priority is less than the parameter PQNode. Zero if they are the same.
     * Larger than zero if the parameter PQNode is less than this PQNode.
     * @param tpqNode node to compare against
     * @return integer based on the comparison
     */
    @Override
    public int compareTo(PQNode<T> tpqNode) {
        if(priority == tpqNode.priority) {
            return secPriority - tpqNode.secPriority;
        }
        return priority < tpqNode.priority ? -1 : 1;
    }
    
    public PQNode<T> getNext(){
    	return front;
    }
    public T getElement(){
    	return element;
    }
    public void setNext(PQNode<T> current)
    {
    	this.front = current;
    }
    
    public boolean hasNext()
    {
    	return front != null;
    }
    
    public double getPriority()
    {
    	return priority;
    }
    
}
