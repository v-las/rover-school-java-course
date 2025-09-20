package homeworks.homework008;

public class Person {
    //    Задача №1
    //    Необходимо создать класс homeworks.homework008.temp.Person с полями: имя, возраст, пол.
    //    Класс должен иметь метод - getName, метод возвращает имя с префиксом “Mr. ”
    //    если пол указан как мужской и префикс “Mrs. ” если женский.

    String firstName;
    String lastName;
    int age;
    String gender;

    public Person(String firstName, String lastName, int age, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public Person(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        if (gender.equals("male")) {
            return "Mr." + lastName;
        } else if (gender.equals("female")) {
            return "Mrs." + lastName;
        } else {
            return lastName;
        }
    }
}
