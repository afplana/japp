package ao.jfpack.patterns.iterator;

public class GenericArrayIterator<T> implements ListIterator<T> {

    private final T[] elements;

    public GenericArrayIterator(T[] array) {
        this.elements = array;
    }

    @Override
    public Iterator<T> getIterator() {
        return new Iterator<>() {
            int index;
            @Override
            public boolean hasNext() {
                return index < elements.length;
            }

            @Override
            public T next() {
                return elements[index++];
            }
        };
    }
}
