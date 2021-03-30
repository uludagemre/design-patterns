package patterns.solid.ocp.application;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        List<Student> studentList = Arrays.asList(
                new Student("Emre", Gender.MALE, Class.A),
                new Student("Emel", Gender.FEMALE, Class.B),
                new Student("Erkan", Gender.MALE, Class.C),
                new Student("Sena", Gender.FEMALE, Class.A),
                new Student("Aylin", Gender.FEMALE, Class.B)
        );

        // Bad implementation:
        StudentFilter sf = new StudentFilter();

        System.out.println("Class A students:");
        sf.filterByClass(studentList, Class.A).forEach(System.out::println);

        System.out.println("\nClass B students:");
        sf.filterByClass(studentList, Class.B).forEach(System.out::println);

        System.out.println("\nMale students:");
        sf.filterByGender(studentList, Gender.MALE).forEach(System.out::println);

        System.out.println("\nFemale students:");
        sf.filterByGender(studentList, Gender.FEMALE).forEach(System.out::println);

        System.out.println("\nMale students from C Class:");
        sf.filterByGenderAndClass(studentList, Gender.MALE, Class.C).forEach(System.out::println);

        // Good implementation:

        EnhancedFilter enhancedFilter = new EnhancedFilter();

        System.out.println("\nClass A students:");
        enhancedFilter.filterItems(studentList, new ClassCondition<Student>(Class.A)).forEach(System.out::println);

        System.out.println("\nClass B students:");
        enhancedFilter.filterItems(studentList, new ClassCondition<Student>(Class.B)).forEach(System.out::println);

        System.out.println("\nMale students:");
        enhancedFilter.filterItems(studentList, new GenderCondition(Gender.MALE)).forEach(System.out::println);

        System.out.println("\nFemale students:");
        enhancedFilter.filterItems(studentList, new GenderCondition(Gender.FEMALE)).forEach(System.out::println);
    }
}
