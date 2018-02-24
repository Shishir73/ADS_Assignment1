package adsassignment.Tests.TestsFromTroels;

import adsassignment.priorityqueue.IPriorityQueue;
import adsassignment.priorityqueue.linearpriorityqueue.LinearPQ;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LinearPQTest {

    IPriorityQueue<String> pq;

    @Before
    public void setup() {
        pq = new LinearPQ<>();
    }

    @Test
    public void testAdd() {
        assertTrue(pq.size() == 0);
        pq.add("A", 7);
        assertTrue(pq.size() == 1);
        assertTrue(pq.contains("A"));
        pq.add("B", 5);
        pq.add("A", 3);
        pq.add("C", 2);
        pq.add("D", 5);
        assertTrue(pq.size() == 5);

        assertTrue(pq.contains("C"));
        assertTrue(pq.contains("A"));
        assertTrue(pq.contains("B"));
        assertTrue(pq.contains("D"));
    }

    @Test
    public void testGetNext() {
        pq.add("A", 4);
        pq.add("B", 7);
        pq.add("C", 2);
        pq.add("D", 4);
        pq.add("E", 6);
        pq.add("F", 9);
        pq.add("G", 3);
        assertTrue(pq.getNext().equals("C"));
        assertTrue(pq.getNext().equals("G"));
        assertTrue(pq.getNext().equals("A"));
        assertTrue(pq.getNext().equals("D"));
        assertTrue(pq.getNext().equals("E"));
        assertTrue(pq.getNext().equals("B"));
        assertTrue(pq.getNext().equals("F"));
    }

    @Test
    public void testPriority() {
        assertTrue(pq.getNext() == null);
        assertTrue(pq.isEmpty());
        pq.add("A", 5);
        assertFalse(pq.isEmpty());
        pq.add("B", 5);
        pq.add("C", 5);
        pq.add("D", 3);
        pq.add("E", 3);
        pq.add("F", 2);
        pq.add("G", 3);
        pq.add("H", 3);
        pq.add("I", 2);
        pq.add("A", 1);
        assertTrue(pq.size() == 10);
        assertTrue(pq.contains("A"));
        assertTrue(pq.contains("A"));
        assertEquals("A",pq.getNext());
        assertTrue(pq.contains("A"));
        assertTrue(pq.contains("F"));
        assertTrue(pq.contains("I"));
        assertEquals("F",pq.getNext());
        assertFalse(pq.contains("F"));
        assertEquals("I",pq.getNext());
        assertEquals("D",pq.getNext());
        assertEquals("E",pq.getNext());
        assertFalse(pq.isEmpty());
        assertEquals("G",pq.getNext());
        assertEquals("H",pq.getNext());
        assertEquals("A",pq.getNext());
        assertFalse(pq.contains("A"));
        assertEquals("B",pq.getNext());
        assertEquals("C",pq.getNext());
        assertEquals(pq.getNext(), null);
        assertTrue(pq.isEmpty());
    }

    @Test
    public void testSecondaryPriority() {
        pq.add("A", 5);
        pq.add("B", 5);
        pq.add("D", 3);
        pq.add("C", 5);
        pq.add("E", 3);


        assertEquals(pq.getNext(),"D");
        assertEquals(pq.getNext(),"E");
        assertEquals(pq.getNext(),"A");
        assertEquals(pq.getNext(),"B");
        assertEquals(pq.getNext(),"C");
        assertEquals(pq.getNext(), null);
    }

    @Test
    public void testClear() {
        assertEquals(pq.size(), 0);
        pq.clear();
        assertEquals(pq.size(), 0);
        pq.add("A", 5);
        pq.add("B", 5);
        pq.add("D", 3);
        pq.add("C", 5);
        pq.add("E", 3);
        pq.clear();
        assertFalse(pq.contains("A"));
        assertFalse(pq.contains("B"));
        assertFalse(pq.contains("C"));
        assertFalse(pq.contains("D"));
        assertFalse(pq.contains("E"));
        assertEquals(pq.size(), 0);
    }

    @Test
    public void testLarge() {
        pq.add("A", 5);
        pq.add("B", 5);
        pq.add("C", 3);
        pq.add("D", 5);
        pq.add("E", 3);
        pq.add("F", 1);
        pq.add("G", 6);
        pq.add("H", 2);
        pq.add("I", 8);
        pq.add("J", 7);
        pq.add("K", 9);
        pq.add("L", 0);
        pq.add("M", 6);
        pq.add("N", 1);
        pq.add("O", 2);
        pq.add("P", 7);
        pq.add("Q", 4);
        for(char i = 65; i < 82; i++) {
            Character c = Character.valueOf(i);
            assertTrue(pq.contains(String.valueOf(c)));
        }
        String[] order = {"L", "F", "N", "H", "O", "C", "E", "Q", "A", "B", "D", "G", "M", "J", "P", "I", "K"};
        int count = 0;
        for (String s : order) {
            assertEquals(s, pq.getNext());
            count++;
        }
        System.out.println(count);
        assertTrue(pq.getNext() == null);
    }

    @Test
    public void testSize() {
        assertEquals(0, pq.size());
        assertTrue(pq.isEmpty());
        pq.add("A", 5);
        pq.add("B", 5);
        pq.add("C", 3);
        pq.add("D", 5);
        pq.add("E", 3);
        assertEquals(5, pq.size());
        assertFalse(pq.isEmpty());
        for(int i = 0; i < 100; i++) {
            pq.add("F", 3);
            assertEquals(6+i, pq.size());
        }
        pq.clear();
        assertEquals(0, pq.size());
        assertTrue(pq.isEmpty());

    }

    @Test
    public void testContains() {
        assertFalse(pq.contains("A"));
        pq.add("A", 5);
        assertTrue(pq.contains("A"));
        pq.add("B", 5);
        pq.add("C", 3);
        pq.add("D", 5);
        pq.add("E", 3);
        assertTrue(pq.contains("B"));
        assertTrue(pq.contains("C"));
        assertTrue(pq.contains("D"));
        assertTrue(pq.contains("E"));
        pq.clear();
        assertFalse(pq.contains("B"));
        assertFalse(pq.contains("C"));
        assertFalse(pq.contains("D"));
        assertFalse(pq.contains("E"));
    }

    @Test
    public void testNothingLost() {
        P[] ps = {
                new P("A", 5),
                new P("B", 5),
                new P("C", 3),
                new P("D", 5),
                new P("E", 3),
                new P("F", 1),
                new P("G", 6),
                new P("H", 2),
                new P("I", 8),
                new P("J", 7),
                new P("K", 9),
                new P("L", 0),
                new P("M", 6),
                new P("N", 1),
                new P("O", 2),
                new P("P", 7),
                new P("Q", 4)
        };
        for (P p : ps) {
            pq.add(p.e, p.p);
            assertTrue(pq.contains(p.e));
        }
        List<String> list = new LinkedList<String>();
        for (P p : ps) {
            list.add(p.e);
        }

        while(!list.isEmpty()) {
            String next = pq.getNext();
            assertTrue(!pq.contains(next));
            list.remove(next);
            for (String s : list) {
                assertTrue(pq.contains(s));
            }
        }
    }

    private class P {
        String e;
        int p;

        public P(String e, int p) {
            this.e = e;
            this.p = p;
        }
    }
}
