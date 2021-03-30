package patterns.builder;

import java.util.ArrayList;
import java.util.List;

class ExerciseSolution {
    public static void main(String[] args) {
        CodeBuilder codeBuilder = new CodeBuilder("Person")
                .addField("String", "name")
                .addField("int", "age");
        System.out.println(codeBuilder);
    }
}

class CodeBuilder {
    String className;
    List<Field> fields = new ArrayList<>();

    public CodeBuilder(String className) {
        this.className = className;
    }

    public CodeBuilder addField(String name, String type) {
        fields.add(new Field(name, type));
        return this;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field : fields) {
            stringBuilder.append("\tpublic ").append(field.type).append(" ").append(field.name).append(";\n");
        }

        return "public class " + className + "\n"
                + "{\n"
                + stringBuilder.toString()
                + "}\n";

    }
}

class Field {
    String name;
    String type;

    public Field(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
