package FirstTask;

import java.util.Iterator;

/**
 * Своя реализация HashMap.
 */
/*
    Хэш мап представляет собой список состоящий из связанных списков(бакетов)
    для каждого элемента высчитывается с помощью хэшфункции id бакета в который он будет записан
    в идеале в каждом бакете должно храниться 1 значение, тогда скорость поиска элемента будет
    оставаться констатной равной О(1)
    так же будем пользоваться дженериками
*/

public class MyHashMap<K, V> {
    private int def_capacity = 16;
    private MyLinkedList<K, V>[] buckets;

    //конструктор без аргументов
    public MyHashMap(){
        buckets = new MyLinkedList[def_capacity];
        for(int i = 0; i < def_capacity; i++){
            buckets[i] = new MyLinkedList<>();
        }
    }
    //конструктор с указанием нужного размера
    public MyHashMap(int capacity){
        buckets = new MyLinkedList[capacity];
        for(int i = 0; i < capacity; i++){
            buckets[i] = new MyLinkedList<>();
        }
        def_capacity = capacity;
    }
    private int idFromHash(K key){
        return key.hashCode() % def_capacity;
    }
    public void put(K key, V value){
        int index = idFromHash(key);
        buckets[index].add(key,value);
    }
    public V get(K key){
        int index = idFromHash(key);
        for(Node<K, V> node : buckets[index]){
            if(node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }
    public void remove(K key) {
        int index = idFromHash(key);
        for(Node<K, V> node : buckets[index]){
            if(node.key.equals(key)) {
                buckets[index].remove(key);
                return;
            }
        }
    }
}
