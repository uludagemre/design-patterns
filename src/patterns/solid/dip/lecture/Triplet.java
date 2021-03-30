package patterns.solid.dip.lecture;

public class Triplet<A, B, C> {
    private final A first;
    private final B second;
    private final C third;

    public Triplet(A first, B second, C third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public A getValue0() {
        return first;
    }

    public B getValue1() {
        return second;
    }

    public C getValue2() {
        return third;
    }
}
