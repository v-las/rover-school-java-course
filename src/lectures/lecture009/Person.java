package lectures.lecture009;

public class Person {
    private String name;
    public int age;
    private char sex;

    public Person(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }

    public int sumPublic(int a, int b) {
        return a + b;
    }

    public static int sumStatic(int a, int b) {
        return a + b;
    }

//    public static String getAge() {
//        return age;
//    }


}
