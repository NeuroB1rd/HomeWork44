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
    private int DEF_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private MyLinkedList<K, V>[] buckets;

    //конструктор без аргументов
    public MyHashMap(){
        buckets = new MyLinkedList[DEF_CAPACITY];
        for(int i = 0; i < DEF_CAPACITY; i++){
            buckets[i] = new MyLinkedList<>();
        }
    }
    //конструктор с указанием нужного размера
    public MyHashMap(int capacity){
        buckets = new MyLinkedList[capacity];
        for(int i = 0; i < capacity; i++){
            buckets[i] = new MyLinkedList<>();
        }
        DEF_CAPACITY = capacity;
    }
    //получаем id из хэш
    private int idFromHash(K key){
        return key.hashCode() % DEF_CAPACITY;
    }
    //метод изменения размера
    public void resize(int newCapacity) {
        MyLinkedList<K, V>[] newBuckets = new MyLinkedList[newCapacity];
        //инициализируем каждый новый бакет
        for (int i = 0; i < newCapacity; i++) {
            newBuckets[i] = new MyLinkedList<>();
        }
        //перераспределяем с новым размером
        for (MyLinkedList<K, V> bucket : buckets) {
            for (Node<K, V> node : bucket) {
                int newIndex = node.key.hashCode() % newCapacity;
                newBuckets[newIndex].add(node.key, node.value);
            }
        }

        buckets = newBuckets;
        DEF_CAPACITY = newCapacity;
    }
    //количество элементов
    public int size() {
        int size = 0;
        for (MyLinkedList<K, V> bucket : buckets) {
            size += bucket.size();
        }
        return size;
    }
    //количество бакетов
    public int getCountBackets(){
        int count = 0;
        for (MyLinkedList<K, V> bucket : buckets) {
            count++;
        }
        return count;
    }

    public void put(K key, V value) {
        int index = idFromHash(key);
        //при вставке в бакет проверяем не перегружен ли он, если перегружен то изменяем размер таблицы
        if (buckets[index].size() >= DEF_CAPACITY * LOAD_FACTOR) {
            int newCapacity = DEF_CAPACITY * 2;
            resize(newCapacity);
        }
        buckets[index].add(key, value);
    }

    public V get(K key){
        int index = idFromHash(key);
        //идем по бакету и ищем нужный элемент
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
