package patterns.solid.ocp.application;

import java.util.List;
import java.util.stream.Stream;

public class EnhancedFilter implements Filter<Student> {
    @Override
    public Stream<Student> filterItems(List<Student> list, Condition<Student> cond) {
        return list.stream().filter(cond::isSatisfied);
    }
}
