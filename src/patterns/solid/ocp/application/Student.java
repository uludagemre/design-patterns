package patterns.solid.ocp.application;

public class Student {
    private final String name;
    private final Gender gender;
    private final Class classType;

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Class getClassType() {
        return classType;
    }

    public Student(String name, Gender gender, Class classType) {
        this.name = name;
        this.gender = gender;
        this.classType = classType;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", classType=" + classType +
                '}';
    }
}
