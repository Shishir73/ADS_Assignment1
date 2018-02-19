package adsassignment.LQTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adsassignment.priorityqueue.IPriorityQueue;
import adsassignment.priorityqueue.linearpriorityqueue.LinearPQ;

class LinearPQTest {
	private IPriorityQueue<String> pq;
	
	@BeforeEach
	public void initializePQ()
	{
		pq = new LinearPQ<String>();
	}
	
	
	@Test
	public void testIfPqIsEmptyByinserting1Element()
	{
		System.out.println("Adding elements: A");
		pq.add("A", 1.0);
		System.out.println("Is PQueue is empty? " +pq.isEmpty());
		System.out.println();
		assertTrue(pq.isEmpty()); // Priority Queue is not empty	
	}

	@Test
	public void testIfPqIsEmptyByRemovingElement()
	{
		System.out.println("Adding elements");
		pq.add("B", 2.0);
		pq.add("A", 2.0);
		pq.add("C", 1.5);
		pq.add("C", 1.0);
		
		pq.printPQ();
		System.out.println("Removing element: "+pq.getNext());
		System.out.println("Removing element: "+pq.getNext());
		System.out.println("Removing element: "+pq.getNext());
		System.out.println("Removing element: "+pq.getNext());
		System.out.println("Is PQueue is empty? " +pq.isEmpty());
		System.out.println();
		assertTrue(pq.isEmpty());
	}
	
	@Test
	public void testIfHighPriorityElemRemoveFirstAfterInsertingLast()
	{
		System.out.println("Adding elements");
		pq.add("B", 2.0);
		pq.add("A", 2.0);
		pq.add("C", 1.0);
		
		pq.printPQ();
		System.out.println();
		 
		assertEquals("C",pq.getNext(), "Shoud be C:  ");
	}
	
	@Test
	public void testIfRemovingMorethanInsertedElementsGivesNull()
	{
		System.out.println("Adding elements");
		pq.add("B", 2.0);
		pq.add("A", 2.0);
		
		pq.printPQ();
		System.out.println();
		pq.getNext();
		pq.getNext();
		
		assertEquals(null,pq.getNext(), "Shoud be Null:  ");
	}
	
	@Test
	public void testPqClearMethod()
	{
		System.out.println("Adding elements");
		pq.add("B", 2.0);
		pq.add("A", 2.0);
		
		pq.printPQ();
		System.out.println();
		pq.getNext();
		pq.getNext();
		assertTrue(pq.isEmpty());
		assertEquals(null,pq.getNext(), "Shoud be Null:  ");
	}
	
	@Test
	public void testPqContainsMethod()
	{
		System.out.println("Adding elements");
		pq.add("B", 2.0);
		pq.add("A", 2.0);
		pq.add("W", 3.0);
		pq.add("A", 1.0);
		pq.add("U", 3.0);
		pq.add("F", 5.0);
		pq.add("R", 3.0);
		pq.add("Z", 8.0);
		
		pq.printPQ();
		
		System.out.println();
		
		assertTrue(pq.contains("A"));
		assertTrue(pq.contains("W"));
		assertTrue(pq.contains("X")); // Priority Queue does not contain "X"
		assertTrue(pq.contains("U"));
		assertTrue(pq.contains("R"));
	}
	
	@Test
	public void testIfNullElementCanBeAdded()
	{
		System.out.println("Adding elements");
		pq.add("B", 2.0);
		pq.add("A", 2.0);
		pq.add("W", 3.0);
		pq.add("A", 1.0);
		pq.add("U", 3.0);
		pq.add(null, 5.0);
		pq.add("R", 3.0);
		pq.add("Z", 8.0);
		
		pq.printPQ();
		
		System.out.println();
		
		assertTrue(pq.contains("A"));
		assertTrue(pq.contains(null)); // Priority Queue does not contain "null"
		assertTrue(pq.contains("U"));
	}
	
	
	
}
