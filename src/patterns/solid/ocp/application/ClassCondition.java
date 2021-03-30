package patterns.solid.ocp.application;

public class ClassCondition<S> implements Condition<Student> {
    private final Class classType;

    public ClassCondition(Class classType) {
        this.classType = classType;
    }

    @Override
    public boolean isSatisfied(Student item) {
        return item.getClassType() == classType;
    }
}
