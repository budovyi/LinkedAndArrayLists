package linkedarraylists;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> implements MyList<T> {
    private int index = 0;
    private T[] array = (T[]) new Object[10];
    private double loadFactor = 0.75;
    private double inc = 1.5;

    @Override
    public T get(int i) {
        return array[i];
    }

    @Override
    public void add(T t) {
        array[index] = t;
        index++;

        if (array.length * loadFactor < index) {
            T[] arrayTwo = (T[]) new Object[(int) (array.length * inc)];
            System.arraycopy(array, 0, arrayTwo, 0, array.length);
            array = arrayTwo;
        }
    }

    @Override
    public void remove(int i) {
        while (array[i] != null) {
            array[i] = array[i + 1];
            i++;
        }
        index--;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.stream(array).filter(Objects::nonNull).toArray());
    }
}
