package patterns.solid.ocp.application;

interface Condition<T> {
    boolean isSatisfied(T item);
}
