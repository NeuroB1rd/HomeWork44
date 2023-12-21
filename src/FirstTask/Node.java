package FirstTask;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

/**
 * Node для MyLinkedList.
 */
//Используем generic для того,чтобы хранить нужный тип данных.
public class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;
    public Node(K key, V value){
        this.key = key;
        this.value = value;
    }

    public V getValue() {
        return value;
    }
}
