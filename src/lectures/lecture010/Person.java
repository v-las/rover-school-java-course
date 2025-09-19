package lectures.lecture010;

public class Person {
    private String name;
    private int age;
    private char sex;

    public Person(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.sex = 'u';
    }
    public Person(String name) {
        this.name = name;
        this.age = 0;
        this.sex = 'u';
    }
    public Person() {
        this.name = "NoName";
        this.age = 0;
        this.sex = 'u';
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
