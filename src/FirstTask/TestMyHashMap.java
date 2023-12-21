package FirstTask;

import org.junit.Test;

import java.sql.SQLOutput;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestMyHashMap {
    @Test
    public void testGet() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("One", 1);
        myHashMap.put("Two", 2);

        assertEquals(Integer.valueOf(1), myHashMap.get("One"));
        assertEquals(Integer.valueOf(2), myHashMap.get("Two"));
        assertNull(myHashMap.get("Three"));
    }

    @Test
    public void testRemove() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("One", 1);
        myHashMap.put("Two", 2);
        myHashMap.put("Three", 3);

        myHashMap.remove("Two");
        assertNull(myHashMap.get("Two"));
        assertEquals(2, myHashMap.size());
    }

    @Test
    public void testResize() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>(4);
        myHashMap.put("FB", 1);
        myHashMap.put("Ea", 2);
        myHashMap.put("Three", 3);

        assertEquals(3, myHashMap.size());

        myHashMap.put("Four", 4);
        myHashMap.put("Five", 5);

        assertEquals(5, myHashMap.size());
        assertEquals(4,myHashMap.getCountBackets());
    }
    @Test
    public void testGetWithCollisions() {
        //У этих строк одинаковых хэшкод
        String str1 = "FB";
        String str2 = "Ea";
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>(4);
        myHashMap.put(str1, 1);
        myHashMap.put(str2, 5);
        System.out.println(str1.hashCode() + "----" + str2.hashCode());

        assertEquals(Integer.valueOf(1), myHashMap.get(str1));
        assertEquals(Integer.valueOf(5), myHashMap.get(str2));
    }
}
