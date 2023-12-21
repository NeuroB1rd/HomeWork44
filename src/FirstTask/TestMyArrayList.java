package FirstTask;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestMyArrayList {
    @Test
    public void testAdd() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            myArrayList.add("Element" + i);
            arrayList.add("Element" + i);
        }

        for (int i = 1; i <= 1000; i++) {
            assertEquals(arrayList.get(i - 1), myArrayList.get(i - 1));
            assertEquals(arrayList.size(), myArrayList.size());
        }
    }

    @Test
    public void testAddWithResize() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            myArrayList.add(i);
            arrayList.add(i);
        }

        assertEquals(arrayList.size(), myArrayList.size());
        for (int i = 1; i <= 1000; i++) {
            assertEquals(arrayList.get(i - 1), myArrayList.get(i - 1));
        }
    }

    @Test
    public void testRemove() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            myArrayList.add("Element" + i);
            arrayList.add("Element" + i);
        }

        for (int i = 1000; i > 500; i--) {
            myArrayList.remove(i - 1);
            arrayList.remove(i - 1);
        }

        assertEquals(arrayList.size(), myArrayList.size());
        for (int i = 1; i <= 500; i++) {
            assertEquals(arrayList.get(i - 1), myArrayList.get(i - 1));
        }
    }
    @Test
    public void testGet() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            myArrayList.add("Element" + i);
            arrayList.add("Element" + i);
        }

        for (int i = 1; i <= 1000; i++) {
            assertEquals(arrayList.get(i - 1), myArrayList.get(i - 1));
        }
    }

    @Test
    public void testSize() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            myArrayList.add(i);
            arrayList.add(i);
        }

        assertEquals(arrayList.size(), myArrayList.size());

        myArrayList.remove(500);
        arrayList.remove(500);

        assertEquals(arrayList.size(), myArrayList.size());
    }
}
