package patterns.solid.ocp.application;

import java.util.List;
import java.util.stream.Stream;

interface Filter<T> {
    Stream<T> filterItems(List<T> list, Condition<T> cond);
}
