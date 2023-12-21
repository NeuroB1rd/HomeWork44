package FirstTask;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Своя реализация LinkedList.
 */

//LinkedList это список, где элемент списка содержит ссылку на следующий.
//используем generic для того чтобы хранить данные разных типов
public class MyLinkedList<K, V> implements Iterable<Node<K, V>> {
    //Первая нода в списке
    private Node<K, V> last;

    //Добавляение элемента. Ссылка на предыдущий элемент записывается в поле нового,
    // а ссылка на новый элемент становиться последней
    public void add(K key, V value){
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = last;
        last = newNode;
    }
    //Поиск элемента.В промежуточное поле кладем ссылку на последний элемент
    // и идем по списку пока не найдем нужный
    public V get(K key){
        //Промежуточный элемент
        Node<K, V> current = last;
        //Пока элемент не null ищем дальше
        while(current != null){
            //если ключ элемента совпал с искомым возвращаем результат
            if(current.key.equals(key)){
                return current.value;
            }
            //кладем в промежуточное поле следующий элемент
            current = current.next;
        }
        //Если не нашли возвращаем null
        return null;
    }

    public void remove(K key){
        Node<K, V> current = last;
        Node<K, V> buf = null;

        while(current != null && !current.key.equals(key)){
            buf = current;
            current = current.next;
        }

        if(current != null){
            if(buf != null){
                last = current.next;
            }else{
                buf.next = current.next;
            }
        }
    }
    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<Node<K, V>>() {
            private Node<K, V> current = last;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<K, V> temp = current;
                current = current.next;
                return temp;
            }
        };
    }

}
