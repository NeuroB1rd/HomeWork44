package FirstTask;

import java.util.Arrays;

/**
 * Своя реализация ArrayList.
 */
public class MyArrayList<T> {
    private int def_capacity = 16;
    private int size = 0;
    private T[] arr;
    //изменение размера массива
    private void resize(){
        int newCapacity = 0;
        if (arr == null || size == arr.length) {
            if (arr == null) {
                //если не существует инициализируем
                arr = (T[]) new Object[def_capacity];
            } else {
                //новый размер массива высчитывается,если он не превысит максимальный
                if (arr.length <= Integer.MAX_VALUE / 2) {
                    newCapacity = arr.length * 2;
                } else {
                    //устанавливаем максимальный размер при необходимости
                    newCapacity = Integer.MAX_VALUE;
                }
                //копируем с новым размером
                arr = Arrays.copyOf(arr, newCapacity);
            }
        }
    }
    public void add(T obj){
        resize();
        arr[size] = obj;
        size++;
    }
    public T get(int i){
        return (T) arr[i];
    }
    public void remove(int index){
        //сдвигаем часть массива из позиции index+1 в позицию index, это перезапишет удаляемый элемент
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        //очищаем последний элемент
        arr[size - 1] = null;
        size--;
    }


    public int size() {
        return size;
    }
}
