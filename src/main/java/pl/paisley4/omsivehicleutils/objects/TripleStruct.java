package pl.paisley4.omsivehicleutils.objects;

public class TripleStruct<T, U, V> {

    public T first;
    public U second;
    public V third;

    public TripleStruct() {}

    public TripleStruct(T first, U second, V third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    public V getThird() {
        return third;
    }

    public void setThird(V third) {
        this.third = third;
    }
}
