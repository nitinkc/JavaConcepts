package nitin.generic.examples;

public class GenericNumberContainer<T extends Number> {
    private T obj;

    public GenericNumberContainer() {}

    public GenericNumberContainer(T t) {
        obj = t;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T t) {
        obj = t;
    }
}
