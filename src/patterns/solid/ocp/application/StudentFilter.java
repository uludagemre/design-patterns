package patterns.solid.ocp.application;

import java.util.List;
import java.util.stream.Stream;

class StudentFilter {
    Stream<Student> filterByClass(List<Student> studentList, Class type) {
        return studentList.stream().filter(s -> s.getClassType() == type);
    }

    Stream<Student> filterByGender(List<Student> studentList, Gender gender) {
        return studentList.stream().filter(s -> s.getGender() == gender);
    }

    Stream<Student> filterByGenderAndClass(List<Student> studentList, Gender gender, Class classType) {
        return studentList.stream().filter(s -> s.getGender() == gender && s.getClassType() == classType);
    }
}
