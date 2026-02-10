public class MyArrayList<T> {

    private Object[] data;   // internal array
    private int size = 0;    // number of elements stored

    // constructor
    public MyArrayList() {
        data = new Object[2]; // small size to see resizing clearly
    }

    // add element
    public void add(T value) {
        if (size == data.length) {
            resize();
        }
        data[size] = value;
        size++;
    }

    // resize internal array
    private void resize() {
        Object[] temp = new Object[data.length * 2];

        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }

        data = temp;
    }

    // get element
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return (T) data[index]; // safe cast
    }

    // current size
    public int size() {
        return size;
    }
}
