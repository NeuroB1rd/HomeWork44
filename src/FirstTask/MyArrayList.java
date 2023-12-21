package FirstTask;

import java.util.Arrays;

/**
 * Своя реализация ArrayList.
 */
public class MyArrayList<T> {
    private int def_capacity = 16;
    private int size = 0;
    private T[] arr;
    private void resize(){
        if(size == arr.length){
            int newCapacity = def_capacity * 2;
            arr = Arrays.copyOf(arr, newCapacity);
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
    public void remove(){

    }


}
