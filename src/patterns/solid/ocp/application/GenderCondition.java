package patterns.solid.ocp.application;

public class GenderCondition implements Condition<Student> {
    private final Gender gender;

    public GenderCondition(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean isSatisfied(Student item) {
        return gender == item.getGender();
    }
}
