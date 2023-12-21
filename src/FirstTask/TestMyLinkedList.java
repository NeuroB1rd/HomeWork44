package FirstTask;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class TestMyLinkedList {
    @Test
    public void testAdd() {
        MyLinkedList<String, Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("One", 1);
        myLinkedList.add("Two", 2);
        myLinkedList.add("Three", 3);

        assertEquals(3, myLinkedList.size());
    }

    @Test
    public void testGet() {
        MyLinkedList<String, Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("One", 1);
        myLinkedList.add("Two", 2);
        myLinkedList.add("Three", 3);

        assertEquals(Integer.valueOf(2), myLinkedList.get("Two"));
        assertNull(myLinkedList.get("Four"));
    }

    @Test
    public void testRemove() {
        MyLinkedList<String, Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("One", 1);
        myLinkedList.add("Two", 2);
        myLinkedList.add("Three", 3);

        myLinkedList.remove("Two");
        assertEquals(2, myLinkedList.size());
        assertNull(myLinkedList.get("Two"));
    }

    @Test
    public void testIterator() {
        MyLinkedList<String, Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("One", 1);
        myLinkedList.add("Two", 2);
        myLinkedList.add("Three", 3);

        int sum = 0;
        for (Node<String, Integer> node : myLinkedList) {
            sum += node.getValue();
        }

        assertEquals(6, sum);
    }

    @Test
    public void testSize() {
        MyLinkedList<String, Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("One", 1);
        myLinkedList.add("Two", 2);
        myLinkedList.add("Three", 3);

        assertEquals(3, myLinkedList.size());

        myLinkedList.remove("Two");
        assertEquals(2, myLinkedList.size());
    }
}
