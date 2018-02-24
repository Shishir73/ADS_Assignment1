package adsassignment.Tests.TestsFromTroels;

import adsassignment.set.ISet;
import adsassignment.set.linearset.LinearSet;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinearSetTest {
    ISet<String> set;

    @Before
    public void setup() {
        set = new LinearSet<>();
    }

    @Test
    public void testAdd() {
        assertTrue(set.size() == 0);
        assertTrue(set.isEmpty());
        set.add("A");
        assertTrue(set.contains("A"));
        assertFalse(set.contains("B"));
        assertTrue(set.size() == 1);
        set.add("B");
        set.add("C");
        assertFalse(set.isEmpty());
        assertTrue(set.contains("B"));
        assertTrue(set.contains("C"));
        assertTrue(set.size() == 3);
    }

    @Test
    public void testClear() {
        assertTrue(set.size() == 0);
        set.clear();
        assertTrue(set.size() == 0);
        assertTrue(set.isEmpty());
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.clear();
        assertTrue(set.size() == 0);
        assertFalse(set.contains("A"));
        assertFalse(set.contains("B"));
        assertFalse(set.contains("C"));
        assertFalse(set.contains("D"));
        assertTrue(set.isEmpty());
    }

    @Test
    public void testMany() {
        for (int i = 0; i < 50; i++) {
            assertTrue(set.size() == i);
            set.add(i + "");
            assertTrue(set.contains(i + ""));
        }
    }

    @Test
    public void testDuplicates() {
        assertTrue(set.size() == 0);
        set.add("A");
        assertTrue(set.size() == 1);
        assertTrue(set.contains("A"));
        set.add("A");
        assertTrue(set.size() == 1);
        assertTrue(set.contains("A"));
    }

    @Test
    public void addRandom() {
        List<String> generated = new LinkedList<>();
        int[] nums = {20,10,21,3,32,46,25,14,13,4,22,35,34,34,3,47,7,23,2,10,11,24,41,4,8,9,34,9,46,29,17,24,49,27,42,5,30,31,25,23,47,45,25,45,36,13,45,24,10,20};
        int count = 0;
        for (int num : nums) {
            set.add(num + "");
            if(!generated.contains(num+"")) {
                count++;
                generated.add(num+"");
            }
            assertTrue(set.contains(num+""));
            assertTrue(set.size() == count);
        }
    }

    @Test
    public void testSize() {
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("E");
        assertEquals(5, set.size());
        assertFalse(set.isEmpty());
        for(int i = 0; i < 100; i++) {
            set.add("" + i);
            assertEquals(6+i, set.size());
        }
        set.clear();
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
    }
}
