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
    private int size = 0;

    //Добавляение элемента. Ссылка на предыдущий элемент записывается в поле нового,
    // а ссылка на новый элемент становиться последней
    public void add(K key, V value){
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = last;
        last = newNode;
        size++;
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
    //получаем последний элемент связанного листа
    public Node<K, V> getLast(){
        return this.last;
    }

    public void remove(K key){
        Node<K, V> current = last;
        Node<K, V> buf = null;

        //ищем нужный узел
        while (current != null && !current.key.equals(key)) {
            buf = current;
            current = current.next;
        }
        //проверяем не первый ли это узел списка
        if (current != null) {
            if (buf != null) {
                //перестраиваем связь в списке
                buf.next = current.next;
            } else {
                //обновляем ссылку на начало списка
                last = current.next;
            }
            size--;
        }
    }
    //переопределяем итератор для использования foreach
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

    public int size() {
        return size;
    }
}
